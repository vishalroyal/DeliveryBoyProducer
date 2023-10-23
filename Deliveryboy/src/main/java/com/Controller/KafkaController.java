package com.Controller;

import com.Service.kafkaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/location")
public class KafkaController {

    @Autowired
    private kafkaservice kafkaservice;

    @PostMapping("/update")
    public ResponseEntity<?>  updateLocation() throws IOException {



        Path path = Paths.get("/Users/vishalpatil/downloads/mongo_Installation.txt");
        byte[] pdfBytes = Files.readAllBytes(path);
        //kafkaservice.updateLocation("("+Math.round(Math.random()*100)+","+Math.round(Math.random()*100)+")");
        kafkaservice.updateLocation("new file",pdfBytes);
        return new ResponseEntity<> (Map.of("Message","File sent "), HttpStatus.OK);
    }


}
