package com.chinaunicom.iot.mapper;

import com.chinaunicom.iot.entity.IotDmpBusEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IotMapper {

    void upSertIot(IotDmpBusEntity iotDmpBusEntity);

    List<IotDmpBusEntity> selectBySerialNumber(String serialNumber);

}
