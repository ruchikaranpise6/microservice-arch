package com.microservices.study.haarlememeerservice.controller;

import com.microservices.study.haarlememeerservice.model.IndividualRequest;
import com.microservices.study.haarlememeerservice.model.IndividualResponse;
import com.microservices.study.haarlememeerservice.service.IndividualService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/harlememeer")
@RequiredArgsConstructor
public class HarlememeerController {

  private final IndividualService individualService;
  @PostMapping
  IndividualResponse createIndividual(@Valid @RequestBody IndividualRequest request){
    return individualService.saveIndividual(request);
  }

}
