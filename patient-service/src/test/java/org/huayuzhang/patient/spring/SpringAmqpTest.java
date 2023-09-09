package org.huayuzhang.patient.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// patient as publisher

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessageToSimpleQueue() {
        String queueName = "simple.queue";
        String msg = "Shit! THis is the Spring AMQP!";
        rabbitTemplate.convertAndSend(queueName, msg);
    }
}
