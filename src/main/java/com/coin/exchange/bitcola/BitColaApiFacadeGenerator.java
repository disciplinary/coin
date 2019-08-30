package com.coin.exchange.bitcola;

import com.coin.common.ApiException;
import com.coin.common.ApiFacadeGenerator;
import com.coin.common.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import retrofit2.Response;

/**
 * @Classname BitColaApiFacade
 * @Description TODO
 * @Date 2019/8/29 15:11
 * @Created by shiyawei
 */
@Slf4j
public class BitColaApiFacadeGenerator extends ApiFacadeGenerator {
    private static String apiKey= "";
    private static String apiSecret = "" ;
    private static String baseUrl="https://api.bitcola.io";
    private static Interceptor interceptor = new BitColaInterceptor(apiKey,apiSecret);

    public  <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, interceptor,baseUrl);
    }

@Override
    public <T> void parseBody(T body) throws ApiException {
        if (body instanceof RespBody) {
            RespBody resp = (RespBody) body;
            if (!resp.getStatus().equalsIgnoreCase("1000")) {
                throw new ApiException(resp.toErrorString());
            }
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    @Override
    public  ApiException parseError(Response<?> response) throws ApiException {
        ErrorCode errorCode = null;
        try {
            errorCode = ErrorCode.fromCode(response.raw().code());
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }

        if (errorCode != null) {
            throw new ApiException(errorCode);
        } else {
            throw new ApiException(response.raw().code(), response.raw().message());
        }
    }


}
