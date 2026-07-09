package com.microservices.study.haarlememeerservice.service;

import com.microservices.study.haarlememeerservice.clients.IndServiceClientUsingRestClient;
import com.microservices.study.haarlememeerservice.clients.IndServiceUsingFeignClient;
import com.microservices.study.haarlememeerservice.exception.ResourceNotFoundException;
import com.microservices.study.haarlememeerservice.model.Individual;
import com.microservices.study.haarlememeerservice.model.IndividualRequest;
import com.microservices.study.haarlememeerservice.model.IndividualResponse;
import com.microservices.study.haarlememeerservice.repository.IndividualRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualService {

  private static final Logger log = LoggerFactory.getLogger(IndividualService.class);

  private final IndividualRepository individualRepository;

  //private final IndServiceClientUsingRestClient indServiceClientUsingRestClient;

  private final IndServiceUsingFeignClient indServiceUsingFeignClient;

  public IndividualResponse saveIndividual(IndividualRequest request) {

    log.debug("Creating employee with email: {}", request.email());

    Individual individual =
        Individual.builder()
            .name(request.name())
            .email(request.email())
            .address(request.address())
            .build();

    individual = individualRepository.save(individual);

    log.debug("Employee created successfully with id {}", individual.getId());

    return map(individual);
  }

  private IndividualResponse map(Individual individual) {

    return new IndividualResponse(
        individual.getId(),
        individual.getName(),
        individual.getEmail(),
        individual.getAddress(),
        indServiceUsingFeignClient.getIndDetails(individual.getId()).nationality());
  }

  public List<IndividualResponse> getAllIndividuals() {
    log.debug("Fetching all individuals");
    return individualRepository.findAll().stream().map(this::map).toList();
  }

  public IndividualResponse getIndividualById(UUID id) {
    log.debug("Fetching individual with id: {}", id);
    return map(
        individualRepository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Individual not found with id: " + id)));
  }
}
