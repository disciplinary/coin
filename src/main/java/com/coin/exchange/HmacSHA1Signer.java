package com.coin.exchange;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 使用 HMAC-SHA1 签名方法对data进行签名
 */
public class HmacSHA1Signer {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * 使用 HMAC-SHA1 签名方法对data进行签名
     *
     * @param message
     *            被签名的字符串
     * @param secret
     *            密钥
     * @return
    加密后的字符串
     */
    public static String sign(String message, String secret) {
        try {
            message = Base64.getEncoder().encodeToString(message.getBytes());
            Mac hmacSHA1 = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA1_ALGORITHM);
            hmacSHA1.init(secretKeySpec);
            byte[] hash = hmacSHA1.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign message.", e);
        }
    }


    public static void main(String[] args) {
        String sign = HmacSHA1Signer.sign("POSThttps://api.fcoin.com/v2/orders1523069544359amount=100.0&price=100.0&side=buy&symbol=btcusdt&type=limit", "3600d0a74aa3410fb3b1996cca2419c8");
        assert sign.equals("DeP6oftldIrys06uq3B7Lkh3a0U=");
        System.out.println(sign);
    }
}
