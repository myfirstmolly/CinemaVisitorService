package com.cinema.visitor.service;

import com.cinema.visitor.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
}
