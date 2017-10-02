package service2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import service2.model.Model1;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by ahiticas on
 * 9/26/2017.
 */

@Service
public class RabbitCommunicationService {

    private final Logger logger = LoggerFactory.getLogger(RabbitCommunicationService.class);

    @Value("${rabbit.host}")
    private String host;
    @Value("${rabbit.queueName}")
    private String queueName;
    Model1 response;

    public Model1 getMessageFromQueue() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(queueName, true, false, false, null);
        logger.info("Waiting for messages...");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                logger.info(" [x] Received '" + message + "'");
                ObjectMapper mapper = new ObjectMapper();

                response = mapper.readValue(message, Model1.class);
            }
        };
        channel.basicConsume(queueName, true, consumer);

        return response;
    }
}
