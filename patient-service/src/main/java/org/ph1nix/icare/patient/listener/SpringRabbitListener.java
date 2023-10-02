package org.ph1nix.icare.patient.listener;

import org.assertj.core.api.ThrowableAssert;
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
        Thread.sleep(100);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) throws InterruptedException {
        System.out.println("\u001B[32mFanout Queue 2 Message received: [ " + msg +" ]\033[0m");
        Thread.sleep(100);
    }
}
