package com.cinema.visitor.service;

import com.cinema.visitor.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getVisitorById(UUID id) {
        return visitorRepository.findById(id).get();
    }

    @Override
    public Visitor updateVisitorBalance(UUID visitorId, double toWithdraw) {
        Visitor visitor = visitorRepository.findById(visitorId).get();
        if(visitor.getMoney() <= toWithdraw)
            throw new IllegalArgumentException("Not enough money");
        visitor.setMoney(toWithdraw);
        visitorRepository.save(visitor);
        return visitor;
    }

    @Override
    public void deleteVisitorById(UUID id) {
        visitorRepository.deleteById(id);
    }

}
