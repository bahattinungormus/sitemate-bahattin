package com.sitemate.challenge.bahattin.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ISSUE")
public class Issue {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ISSUE_NUMBER", nullable = false)
  private Long id;
  @Column(name = "UUID", unique = true, nullable = false)
  private UUID uuid;
  @Column(name = "TITLE")
  private String title;
  @Column(name = "DESCRIPTION")
  private String description;

  public Issue() {
    this.uuid = UUID.randomUUID();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid == null ? this.uuid : uuid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
