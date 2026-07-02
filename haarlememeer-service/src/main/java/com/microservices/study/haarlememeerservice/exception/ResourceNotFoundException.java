package com.microservices.study.haarlememeerservice.exception;

public class ResourceNotFoundException
extends RuntimeException{
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
