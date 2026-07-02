package com.microservices.study.haarlememeerservice.service;

import com.microservices.study.haarlememeerservice.model.Individual;
import com.microservices.study.haarlememeerservice.model.IndividualRequest;
import com.microservices.study.haarlememeerservice.model.IndividualResponse;
import com.microservices.study.haarlememeerservice.repository.IndividualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualService {

  private final IndividualRepository individualRepository;
  public IndividualResponse saveIndividual(IndividualRequest request) {
    Individual individual = Individual.builder()
        .name(request.name())
        .email(request.email())
        .address(request.address())
        .build();
    return map(individualRepository.save(individual));
  }

  private IndividualResponse map(Individual individual){

    return new IndividualResponse(

        individual.getId(),
        individual.getName(),
        individual.getEmail(),
        individual.getAddress()
    );
  }

}
