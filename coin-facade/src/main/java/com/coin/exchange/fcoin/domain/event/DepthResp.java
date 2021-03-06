package com.coin.exchange.fcoin.domain.event;

import com.coin.exchange.fcoin.domain.Depth;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * created by jacky. 2018/7/24 8:43 PM
 */
@Getter
@Setter
public class DepthResp  extends Depth {
    private Set<String> topics;
    private String status;
    private String msg;
    private String type;

}
