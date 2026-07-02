package com.microservices.study.haarlememeerservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record IndividualRequest(
    @NotBlank(message = "Name is required")
  String name,

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
  String email,

    @NotBlank(message = "Address is required")
  String address
){}
