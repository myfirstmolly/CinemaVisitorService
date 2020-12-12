package com.cinema.visitor.rabbitmq;

import com.cinema.visitor.model.Visitor;
import com.cinema.visitor.service.VisitorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    VisitorService visitorService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(Visitor visitor) {
        visitorService.addVisitor(visitor);
    }
}
