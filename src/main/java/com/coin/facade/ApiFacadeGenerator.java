package com.coin.facade;

import com.coin.exchange.fcoin.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * created by jacky. 2018/7/20 9:07 PM
 */
@Slf4j
public abstract class ApiFacadeGenerator {

    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    /**
     * 获取对象
     * @param serviceClass
     * @param interceptor
     * @param baseUrl
     * @param <S>
     * @return
     */
    protected <S> S createService(Class<S> serviceClass, Interceptor interceptor, String baseUrl) {

        if (!httpClient.interceptors().contains(interceptor)) {
            httpClient.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create()).client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    /**
     * 执行同步请求
     * @param call
     * @param <T>
     * @return
     */
    public <T> T executeSync(Call<T> call) {

        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                parseBody(response.body());
                return response.body();
            } else {
                parseError(response);
            }
        } catch (IOException | ApiException e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        throw new IllegalStateException("invalid response from server.");
    }


    protected abstract  <T> void parseBody(T body) throws ApiException;


    public abstract  void parseError(Response<?> response) throws ApiException;
}
