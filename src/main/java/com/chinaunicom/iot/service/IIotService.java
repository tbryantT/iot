package com.chinaunicom.iot.service;

import com.chinaunicom.iot.entity.IotDmpBusEntity;

import java.util.List;

public interface IIotService {

    void upSertIot();
    List<IotDmpBusEntity> selectBySerialNumber(String serialNumber);
}
