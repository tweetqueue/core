package com.tweetqueue.core.model.user;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;

public class UserFactory {
  @CheckReturnValue
  private User getUser(UserId id, String username) {
    return new User(id, username);
  }

  public User getUser(String id, String username) {
    return getUser(getUserId(id), username);
  }

  @CheckReturnValue
  public UserId getUserId(String userId) {
    return new UserId(userId);
  }

  @CheckReturnValue
  public User getUser(String username) {
    return getUser(new UserId(), username);
  }
}
