package com.tweetqueue.core.services.user;

/**
 * Created by javi on 20/5/17.
 */
public class GetUserRequest {

  private final String id;

  public GetUserRequest(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
