package com.microservices.study.haarlememeerservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Individual")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Individual
{
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable=false)
  private String name;

  @Column(unique=true)
  private String email;

  private String address;
}
