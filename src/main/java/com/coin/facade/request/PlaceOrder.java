package com.coin.facade.request;

import com.coin.facade.enums.OrderDirection;
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
   private String type="LIMIT";
   private OrderDirection direction;
   private BigDecimal amount;
}
