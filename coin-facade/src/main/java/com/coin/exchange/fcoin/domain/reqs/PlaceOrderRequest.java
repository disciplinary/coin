package com.coin.exchange.fcoin.domain.reqs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * created by jacky. 2018/8/3 3:09 PM
 */
@Getter
@Setter
@Data
public class PlaceOrderRequest {

   private String pair;
   private String price;
   private String type;
   private String amount;
}
