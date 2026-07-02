package com.microservices.study.haarlememeerservice.repository;

import com.microservices.study.haarlememeerservice.model.Individual;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IndividualRepository extends JpaRepository<Individual, UUID> {
}
