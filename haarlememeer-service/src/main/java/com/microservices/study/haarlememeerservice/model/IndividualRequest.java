package com.microservices.study.haarlememeerservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record IndividualRequest(
  @NotBlank
  String name,

  @Email
  String email,

  @NotBlank String address
){}
