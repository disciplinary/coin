package com.coin.facade.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * created by jacky. 2018/8/3 3:09 PM
 */
@Getter
@Setter
@Data
public class BuyOrder {
   private String pair;
   private String price;
   private String type;
   private String amount;
}
