package com.microservices.study.haarlememeerservice.model;

import java.util.UUID;

public record IndividualResponse(
    UUID id, String name, String email, String address, String nationality) {}
