package com.xunqi.gulimall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 **/

@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}
