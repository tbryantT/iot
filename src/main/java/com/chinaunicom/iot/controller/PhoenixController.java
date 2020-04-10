package com.chinaunicom.iot.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.iot.entity.IotDmpBusEntity;
import com.chinaunicom.iot.entity.Order;
import com.chinaunicom.iot.mapper.IotMapper;
import com.chinaunicom.iot.mapper.OrderMapper;
import com.chinaunicom.iot.service.impl.IotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author whj
 * @Date 2020/4/8/008 22:07
 */
@Controller
@RequestMapping("/test")
public class PhoenixController {

    @Autowired
    private OrderMapper orderMapper;

    private static Logger logger = LoggerFactory.getLogger(PhoenixController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private IotMapper iotMapper;

    @Autowired
    private IotService iotService;

    private static ArrayList<String> list =new ArrayList<String>();

    static {

        list.add("heart");
        list.add("alarm");
        list.add("fault");
        list.add("insert");
        list.add("update");
        list.add("delete");
        list.add("default");
    }

    @GetMapping("/getOrders")
    public void getOrders() {
        Date date = new Date();
        List<Order> orders = orderMapper.getOrders();
        Date data2 = new Date();
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        System.out.println(data2.getTime() - date.getTime());
        System.out.println(data2.getTime());
        System.out.println(date.getTime());
    }

    @GetMapping("/send")
    public void sendMsg(){

        try {
            JSONObject reportData = new JSONObject();
            JSONObject data = new JSONObject();

            for (int i= 0 ;i<=10;i++){

                ArrayList<String> arr =new ArrayList<String>();

                data.put("serialNumber",i+"11111202003201442"+i);
                data.put("timestamp",System.currentTimeMillis());
                data.put("reportType","beforeAnalysis");
                data.put("messageType",list.get(i%7));
                data.put("groupName","小组1");
                data.put("projectName","项目1");
                data.put("deviceType","water-immersion");
                data.put("maker","顺舟");
                data.put("value","cbfe3004000a000000070860101044731334000100010100110454000600a38c0084611d00000ed5010052babe");
                arr.add(data.toJSONString());

                reportData.put("reports",arr);
                logger.info(reportData.toString());
            ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send("iotTest",reportData.toJSONString());
            future.addCallback(o -> System.out.println("消息发送成功：" + reportData),
                    throwable -> System.out.println("消息发送失败：" + reportData));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @GetMapping("/quary")
    public void SelectBySN(){

        System.out.println(iotService.selectBySerialNumber("61111202003201446"));

    }


    public static void main(String[] args) {

    }
}
