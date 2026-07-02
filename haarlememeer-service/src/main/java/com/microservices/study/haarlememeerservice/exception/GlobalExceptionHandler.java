package com.microservices.study.haarlememeerservice.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)

  public ProblemDetail handleNotFoundIndividual(ResourceNotFoundException exception){
      log.error("Resource not found: {}", exception.getMessage());
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND.value());
      problemDetail.setTitle("Resource Not Found");
      problemDetail.setDetail(exception.getMessage());
      return problemDetail;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleValidation(
      MethodArgumentNotValidException ex) {

    String message = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(error ->
            error.getField() + ": " + error.getDefaultMessage())
        .findFirst()
        .orElse("Validation error");

    log.warn("Validation failed: {}", message);

    ProblemDetail problem =
        ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

    problem.setTitle("Validation Failed");
    problem.setDetail(message);

    return problem;
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ProblemDetail handleConstraintViolation(
      ConstraintViolationException ex) {

    log.warn("Constraint violation: {}", ex.getMessage());

    ProblemDetail problem =
        ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

    problem.setTitle("Constraint Violation");
    problem.setDetail(ex.getMessage());

    return problem;
  }

  @ExceptionHandler(Exception.class)
  public ProblemDetail handleGeneric(Exception ex) {

    log.error("Unexpected error occurred", ex);

    ProblemDetail problem =
        ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

    problem.setTitle("Internal Server Error");
    problem.setDetail(ex.getMessage());

    return problem;
  }
}