package org.huayuzhang.booking.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringRabbitListener {
    // @RabbitListener(queues = "simple.queue")
    // public void listenSimpleQueue(String msg) {
    //     System.out.println("Got message:");
    //     System.out.println(msg);
    // }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("Worker 1 Got message:");
        System.out.println(msg);
        Thread.sleep(50);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("                      Worker 2 Got message:");
        System.err.println("                      "+msg);
        Thread.sleep(500); // simulate different consume power
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) {
        System.out.println("fanout.queue1 Got message:");
        System.out.println(msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) {
        System.out.println("fanout.queue2 Got message:");
        System.out.println(msg);
    }

}
