package com.chinaunicom.iot.service.impl;

        import com.chinaunicom.iot.entity.IotDmpBusEntity;
        import com.chinaunicom.iot.mapper.IotMapper;
        import com.chinaunicom.iot.service.IIotService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class IotService implements IIotService {


    @Autowired
    IotMapper iotMapper;

    @Override
    public void upSertIot() {

    }

    @Override
    public List<IotDmpBusEntity> selectBySerialNumber(String serialNumber) {

        return iotMapper.selectBySerialNumber(serialNumber);
    }
}
