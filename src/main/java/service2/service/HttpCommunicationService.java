package service2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service2.model.Model1;

/**
 * Created by ahiticas on
 * 9/25/2017.
 */
@Service
public class HttpCommunicationService {

    @Value("${service1.host}")
    private String host;
    @Value("${service1.port}")
    private Integer port;
    @Value("${service1.endpoint}")
    private String endpoint;

    public Model1 getAddress() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(host + ":" + port + endpoint, Model1.class);
    }
}
