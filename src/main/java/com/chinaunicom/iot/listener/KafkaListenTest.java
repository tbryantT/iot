package com.chinaunicom.iot.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.iot.entity.IotDmpBusEntity;
import com.chinaunicom.iot.mapper.IotMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class KafkaListenTest {

    @Autowired
    IotMapper iotMapper;


    @KafkaListener(topics = {"iotTest"})
    public void listen(ConsumerRecord<?, ?> record) {
//        System.out.println(record.value());
        StringBuilder sb = new StringBuilder();
        String iotJson = record.value().toString();
        JSONObject jsonObject = JSONObject.parseObject(iotJson);
        String reports = jsonObject.getString("reports");
        String reportsJson = reports.substring(2,reports.length() - 2).replace("\\","");

        JSONObject reportsObject = JSONObject.parseObject(reportsJson);
        String serialNumber = reportsObject.getString("serialNumber");
        String timeStamp = sb.append(reportsObject.getString("timestamp")).reverse().toString();
        String reportType = reportsObject.getString("reportType");
        String deviceType = reportsObject.getString("deviceType");
        String groupName = reportsObject.getString("groupName");
        String messageType = reportsObject.getString("messageType");
        String maker = reportsObject.getString("maker");
        String projectName = reportsObject.getString("projectName");
        String value = reportsObject.getString("value");


        IotDmpBusEntity idbe = new IotDmpBusEntity();
        idbe.setDeviceType(deviceType);
        idbe.setTimeStamp(timeStamp);
        idbe.setMaker(maker);
        idbe.setGroupName(groupName);
        idbe.setProjectName(projectName);
        idbe.setReportType(reportType);
        idbe.setMessageType(messageType);
        idbe.setValue(value);
        idbe.setSerialNumber(serialNumber);

        iotMapper.upSertIot(idbe);
    }


}
