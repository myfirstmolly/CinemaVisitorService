package com.cinema.visitor.model;

import com.cinema.visitor.VisitorRequest;
import com.cinema.visitor.VisitorResponse;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
public final class Visitor {

    @Id
    private UUID userId;

    private String name;
    private double money;
    private int age;

    public Visitor() {
        userId = UUID.randomUUID();
    }

    public Visitor(UUID userId, String name, double money, int age) {
        this.userId = userId;
        this.name = name;
        this.money = money;
        this.age = age;
    }

    public static Visitor fromVisitorRequest(VisitorRequest visitorRequest) {
        return new Visitor(UUID.randomUUID(),
                visitorRequest.getName(),
                visitorRequest.getMoney(),
                visitorRequest.getAge());
    }

    public VisitorResponse toVisitorResponse() {
        return VisitorResponse.newBuilder().
                setId(userId.toString()).
                setName(name).
                setMoney(money).
                setAge(age).
                build();
    }

}
