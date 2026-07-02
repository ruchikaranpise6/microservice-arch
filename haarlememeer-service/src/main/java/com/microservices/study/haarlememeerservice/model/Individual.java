package com.microservices.study.haarlememeerservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// Use lowercase table name to match Flyway migration (Postgres folds unquoted identifiers to lower-case)
@Table(name = "individual")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Individual {
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(unique = true)
  private String email;

  private String address;
}
