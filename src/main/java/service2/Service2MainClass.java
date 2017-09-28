package service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service2.service.RabbitCommunicationService;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * Created by ahiticas on
 * 9/25/2017.
 */

@SpringBootApplication
public class Service2MainClass {



    public static void main(String[] args) throws IOException, TimeoutException {
        SpringApplication.run(Service2MainClass.class, args);
    }
}
