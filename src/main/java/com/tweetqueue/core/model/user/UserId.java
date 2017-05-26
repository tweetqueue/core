package com.tweetqueue.core.model.user;

import java.util.UUID;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public class UserId {

  private final UUID id;

  UserId(String id) {
    this.id = fromString(id);
  }

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
