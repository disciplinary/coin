package com.coin.facade.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/8/3 3:09 PM
 */
@Getter
@Setter
@Data
public class PlaceOrder{

   private String pair;
   private BigDecimal price;
   private String type;
   private BigDecimal amount;
}
