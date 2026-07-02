package com.microservices.study.haarlememeerservice.controller;

import com.microservices.study.haarlememeerservice.model.IndividualRequest;
import com.microservices.study.haarlememeerservice.model.IndividualResponse;
import com.microservices.study.haarlememeerservice.service.IndividualService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/individual")
@RequiredArgsConstructor
@Slf4j
public class IndividualController {

  private final IndividualService individualService;
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  IndividualResponse createIndividual(@Valid @RequestBody IndividualRequest request){
    log.info("POST /individual - Creating new individual with email: {}", request.email());
    return individualService.saveIndividual(request);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  List<IndividualResponse> getAllIndividuals(){
    log.info("GET /individual - Fetching all individuals");
    return individualService.getAllIndividuals();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  IndividualResponse getIndividualById(@PathVariable UUID id){
    log.info("GET /individual/{} - Fetching individual by id", id);
    return individualService.getIndividualById(id);
  }

}
