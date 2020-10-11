package com.cinema.visitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class Visitor {

    @Id
    private UUID userId;

    private String name;
    private double money;
    private int age;

    public Visitor(String name, double money, int age) {
        userId = UUID.randomUUID();
        this.name = name;
        this.money = money;
        this.age = age;
    }
}
