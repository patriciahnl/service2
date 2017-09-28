package service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service2.model.Model1;
import service2.service.HttpCommunicationService;
import service2.service.RabbitCommunicationService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by ahiticas on
 * 9/25/2017.
 */
@RestController
public class Controller1 {

    @Autowired
    private HttpCommunicationService httpCommunicationService;
    @Autowired
    private RabbitCommunicationService rabbitCommunicationService;

    @RequestMapping(method = RequestMethod.GET, value = "getAddress", produces = "application/json  ")
    public ResponseEntity<?> getAddress() {

        return new ResponseEntity<Model1>(httpCommunicationService.getAddress(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAsyncMessage")
    public ResponseEntity<?> getAsyncMessage() throws IOException, TimeoutException {

        return new ResponseEntity<Model1>(rabbitCommunicationService.getMessageFromQueue(), HttpStatus.OK);
    }

}
