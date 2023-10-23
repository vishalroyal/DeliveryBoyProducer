package com.Service;

import com.constants.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaservice {

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;
    private Logger logger= LoggerFactory.getLogger(kafkaservice.class);
    public boolean updateLocation(String location,byte[] pdfbytes){
        logger.info("Message producing started ",location);

        kafkaTemplate.send(AppConstant.FILE_TOPIC,location,pdfbytes);

        logger.info("Message produced ",location);
        return true;
    }

}
