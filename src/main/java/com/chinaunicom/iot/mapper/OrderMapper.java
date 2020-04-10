package com.chinaunicom.iot.mapper;

import com.chinaunicom.iot.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author whj
 * @Date 2020/4/8/008 16:07
 */
@Mapper
public interface OrderMapper {
    List<Order> getOrders();

    void updateOrder(@Param("id") Long id, @Param("totalAmount") BigDecimal totalAmount);
}
