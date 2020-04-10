package com.chinaunicom.iot;

import com.chinaunicom.iot.entity.IotDmpBusEntity;
import com.chinaunicom.iot.entity.Order;
import com.chinaunicom.iot.mapper.IotMapper;
import com.chinaunicom.iot.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author whj
 * @Date 2020/4/8/008 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisPhoenixApplicationTests {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IotMapper iotMapper;
    @Autowired
    private IotDmpBusEntity iotDmpBusEntity;

    @Test
    public void testGetOrders() {
        List<Order> orders = orderMapper.getOrders();
        orders.forEach(System.out::println);
    }
    @Test
    public void testInsertIOT_DMP_BUS_TB(){

//        iotMapper.updateIot(iotDmpBusEntity.getSerialNumber(),iotDmpBusEntity.getTimestamp(),
//                iotDmpBusEntity.getReportType(),iotDmpBusEntity.getMessageType(),
//                iotDmpBusEntity.getGroupName(),iotDmpBusEntity.getProjectName(),
//                iotDmpBusEntity.getDeviceType(),iotDmpBusEntity.getMaker(),
//                iotDmpBusEntity.getValue());
        System.out.println(iotDmpBusEntity.getDeviceType());
    }

    @Test
    public void testUpdateOrder() {
        orderMapper.updateOrder(2L, BigDecimal.valueOf(88.8));
    }
}
