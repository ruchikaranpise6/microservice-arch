package com.microservices.study.apigateway;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apigateway")
public class TokenController {

  @GetMapping("/token")
  public String getUser(@AuthenticationPrincipal Jwt jwt) {

    return jwt.getClaimAsString("preferred_username");
  }
}
