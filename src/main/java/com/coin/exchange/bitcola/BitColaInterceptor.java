package com.coin.exchange.bitcola;

import com.coin.exchange.Consts;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okio.Buffer;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;


/**
 * 请求拦截器，在需要时将API键注入请求并对消息签名。
 */
public class BitColaInterceptor implements Interceptor {
    private final String apiKey;
    private final String secret;

    public BitColaInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();
        boolean isSignatureRequired = original.header(Consts.ENDPOINT_SECURITY_TYPE_SIGNED) != null;
        //add heads if required
       if (isSignatureRequired) {
           Long now = System.currentTimeMillis();
           newRequestBuilder.removeHeader(Consts.ENDPOINT_SECURITY_TYPE_SIGNED);
           // 添加Query参数
           HttpUrl.Builder urlBuilder= original.url().newBuilder();
           urlBuilder.addEncodedQueryParameter("accessKey", apiKey).addEncodedQueryParameter("reqTime", now.toString());
           String signature = createSignature( newRequestBuilder.url(urlBuilder.build()).build());
           // 添加签名
           HttpUrl httpUrl= urlBuilder.addEncodedQueryParameter("sign",signature).build();
           // 将最终的url填充到request中
           newRequestBuilder.url(httpUrl);
       }
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }


    /**
     * 创建签名.
     *
     * @param request 请求参数
     * @return
     */
    private String createSignature(Request request) {
        StringBuilder sb = new StringBuilder(1024);
        String method = request.method().toUpperCase();
        StringJoiner joiner = new StringJoiner("&");
        if (method.equalsIgnoreCase("GET")) {
            buildForGet(request, sb, joiner);

        } else if (method.equalsIgnoreCase("POST")) {
            if (request.body() instanceof FormBody) {
                buildForPostFormBody(request, sb, joiner);
            } else if (request.body() instanceof RequestBody) {
                buildForPostRequestBody(request, sb, joiner);
            }
        }
        return EncryptDigestUtil.hmacSign(sb.toString(), secret);
    }

    /**
     *
     *
     * @param request 请求参数
     * @param sb 拼接后的保存
     * @param joiner  字符拼接格式
     */
    private void buildForPostRequestBody(Request request, StringBuilder sb, StringJoiner joiner) {
        String bodyStr = bodyToString(request.body());
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<TreeMap<String, Object>> typeRef = new TypeReference<TreeMap<String, Object>>() {
        };
        try {
            if (StringUtils.isNotBlank(bodyStr)) {
                //排序
                TreeMap<String, Object> params = mapper.readValue(bodyStr, typeRef);
                //拼接
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    joiner.add(entry.getKey() + '=' + entry.getValue());
                }
                sb.append(joiner.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildForPostFormBody(Request request, StringBuilder sb, StringJoiner joiner) {
        FormBody body = (FormBody) request.body();
        TreeMap<String, Object> bodyParm = new TreeMap<>();
        //排序
        for (int i = 0; i < body.size(); i++) {
            bodyParm.put(body.encodedName(i), body.encodedValue(i));
        }
        //拼接
        for (Map.Entry<String, Object> entry : bodyParm.entrySet()) {
            joiner.add(entry.getKey() + '=' + entry.getValue());
        }
        sb.append(joiner.toString());
    }

    private void buildForGet(Request request, StringBuilder sb, StringJoiner joiner) {
        //参数排序
        TreeSet<String> names = new TreeSet(request.url().queryParameterNames());
        //拼接
        for (String key : names) {
            String value = request.url().queryParameter(key);
            joiner.add(key + '=' + urlEncode(value));
        }
       /* //追加问号
        if (!StringUtils.isBlank(joiner.toString())) {
            sb.append("?");
        }*/
        sb.append(joiner.toString());
    }


    private String bodyToString(final RequestBody body) {
        try {
            final RequestBody copy = body;
            final Buffer buffer = new Buffer();
            if (copy != null) {
                copy.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();

        } catch (IOException e) {
            return null;
        }
    }


    /**
     * 使用标准URL Encode编码。注意和JDK默认的不同，空格被编码为%20而不是+。
     *
     * @param s String字符串
     * @return URL编码后的字符串
     */
    private String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("UTF-8 encoding not supported!");
        }
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BitColaInterceptor that = (BitColaInterceptor) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, secret);
    }
}