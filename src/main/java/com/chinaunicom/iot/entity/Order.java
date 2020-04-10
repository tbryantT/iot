package com.chinaunicom.iot.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author whj
 * @Date 2020/4/8/008 16:04
 */
@Data
public class Order {
    private Long id;
    private String orderCode;
    private BigDecimal totalAmount;
    private Date createTime;
    private Long userId;
}
