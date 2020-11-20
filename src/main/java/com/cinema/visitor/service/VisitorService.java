package com.cinema.visitor.service;

import com.cinema.visitor.model.Visitor;
import com.cinema.visitor.model.WithdrawDto;

import java.util.List;
import java.util.UUID;

public interface VisitorService {

    Visitor addVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(UUID id);

    Visitor updateVisitorBalance(UUID visitorId, WithdrawDto newBalance);

    void deleteVisitorById(UUID id);

}
