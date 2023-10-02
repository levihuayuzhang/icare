package org.ph1nix.icare.patient.listener;

import org.assertj.core.api.ThrowableAssert;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringRabbitListener {
    // @RabbitListener(queues = "simple.queue")
    // public void listenSimpleQueue(String msg) {
    //     System.out.println("Message received: [ " + msg +" ]");
    // }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("Consumer 1 Message received: [ " + msg +" ]");
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("                           Consumer 2 Message received: [ " + msg +" ]");
        Thread.sleep(100);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) throws InterruptedException {
        System.out.println("\u001B[36mFanout Queue 1 Message received: [ " + msg +" ]\033[0m");
        // Thread.sleep(10);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) throws InterruptedException {
        System.out.println("\u001B[32mFanout Queue 2 Message received: [ " + msg +" ]\033[0m");
        // Thread.sleep(100);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "icare.direct", type = ExchangeTypes.DIRECT), // type default to direct
            key = {"patient", "doctor", "payment"} // simulate payment
    ))
    public void listenDirectQueue1(String msg) throws InterruptedException {
        System.out.println("\u001B[32mDirect Queue 1 Message received: [ " + msg +" ]\033[0m");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "icare.direct", type = ExchangeTypes.DIRECT), // type default to direct
            key = {"patient", "doctor", "booking"} // simulate booking
    ))
    public void listenDirectQueue2(String msg) throws InterruptedException {
        System.out.println("\u001B[3mDirect Queue 2 Message received: [ " + msg +" ]\033[0m");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "icare.topic", type = ExchangeTypes.TOPIC),
            key = "sexy.#"
    ))
    public void listenTopicQueue1(String msg) throws InterruptedException {
        System.out.println("Topic Queue 1 Message received: [ " + msg +" ]");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "icare.topic", type = ExchangeTypes.TOPIC),
            key = "#.girls"
    ))
    public void listenTopicQueue2(String msg) throws InterruptedException {
        System.err.println("-----------Topic Queue 2 Message received: [ " + msg +" ]");
    }


}
