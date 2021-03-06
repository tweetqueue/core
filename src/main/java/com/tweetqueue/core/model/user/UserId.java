package com.tweetqueue.core.model.user;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

import java.util.UUID;

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
