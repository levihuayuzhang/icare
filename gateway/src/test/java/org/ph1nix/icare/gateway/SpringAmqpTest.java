package org.ph1nix.icare.gateway;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// @RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMsg2SimpleQueue () {
        String queueName = "simple.queue";
        String msg = "Fk, this is simple queue!";
        rabbitTemplate.convertAndSend(queueName, msg);
    }
}
