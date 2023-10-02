package org.ph1nix.icare.gateway.mq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @Test
    public void testSendMsg2WorkQueue () {
        String queueName = "simple.queue";
        String msg = "Work queue msg - ";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName, msg + i);
        }
    }

    @Test
    public void testSendMsg2FanoutExchange () {
        String exchangeName = "icare.fanout";
        String msg = "Fanout Exchange msg - ";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(exchangeName, "", msg + i);
        }
    }

    @Test
    public void testSendMsg2DirectExchange () {
        String exchangeName = "icare.direct";
        String msg = "Direct Exchange msg - ";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(exchangeName, "booking", msg + " \033[0;35mbooking\033[0m "+ i);
            rabbitTemplate.convertAndSend(exchangeName, "payment", msg + " \033[0;33mpayment\033[0m " + i);
            rabbitTemplate.convertAndSend(exchangeName, "patient", msg + " patient " + i);
            rabbitTemplate.convertAndSend(exchangeName, "doctor", msg + " doctor " + i);
        }
    }
}
