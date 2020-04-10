package com.chinaunicom.iot.entity;

import lombok.Data;

@Data
public class IotDmpBusEntity {

        private String serialNumber;
        private String timeStamp;
        private String reportType;
        private String messageType;
        private String groupName;
        private String projectName;
        private String deviceType;
        private String maker;
        private String value;

}
