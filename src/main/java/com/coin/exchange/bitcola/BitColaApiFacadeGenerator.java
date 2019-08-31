package com.coin.exchange.bitcola;

import com.coin.facade.ApiFacadeGenerator;
import com.coin.exchange.bitcola.domain.resp.RespBody;
import com.coin.exchange.fcoin.exception.ApiException;
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
    private static String apiKey= "cd28a3456e877930dfd91713";
    private static String apiSecret = "4045c030224941ed9397de861088305a1e56a84c" ;
    private static String baseUrl="https://api.bitcola.io";
    private static Interceptor interceptor = new BitColaInterceptor(apiKey,apiSecret);
    private static String  status="1000";
    public  <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, interceptor,baseUrl);
    }


    public <T> void parseBody(T body) throws ApiException {
        if (body instanceof RespBody) {
            RespBody resp = (RespBody) body;
            if (!resp.getStatus().equalsIgnoreCase(status)) {
                throw new ApiException(resp.toErrorString());
            }
        }
    }


    public  void parseError(Response<?> response ) throws ApiException {
        throw new ApiException(response.raw().code(), response.raw().message());
    }

}
