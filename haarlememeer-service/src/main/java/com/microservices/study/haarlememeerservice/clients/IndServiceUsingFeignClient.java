package com.microservices.study.haarlememeerservice.clients;

import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ind-service")

public interface IndServiceUsingFeignClient {

  @GetMapping("/ind/{id}")
  IndDetails getIndDetails(
      @PathVariable UUID id
  );
}


