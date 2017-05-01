package com.tweetqueue.core.model.user;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class UserId {
  private final UUID id;

  public UserId(UUID id) {
    this.id = id;
  }

  public UserId() {
    this.id = randomUUID();
  }

  public UUID getId() {
    return id;
  }
}
