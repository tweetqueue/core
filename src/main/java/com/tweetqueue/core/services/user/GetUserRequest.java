package com.tweetqueue.core.services.user;

public class GetUserRequest {

  private final String id;

  public GetUserRequest(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
