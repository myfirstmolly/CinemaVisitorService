package com.cinema.visitor.service;

import com.cinema.visitor.model.Visitor;

import java.util.List;
import java.util.UUID;

public interface VisitorService {

    Visitor addVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(UUID id);

    Visitor updateVisitorBalance(UUID visitorId, double newBalance);

    void deleteVisitorById(UUID id);

}
