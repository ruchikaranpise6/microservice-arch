package com.microservices.study.haarlememeerservice.clients;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class IndServiceClient {

  private final RestClient restClient;

  public IndDetails getIndDetails(UUID id) {
    return restClient.get()
        .uri("http://localhost:8082/ind/{id}", id)
        .retrieve()
        .body(IndDetails.class);
}}
