package com.tweetqueue.core.model.user;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;

import java.util.Collection;

import static java.util.UUID.fromString;

public class UserFactory {
  @CheckReturnValue
  public User getUser(UserId id, String username, String email) {
    return new User(id, username, email);
  }

  public User getUser(UserId id, String username, String email, Collection<SocialInformation> loginInformation) {
    return getUser(id, username, email).setLoginInformation(loginInformation);
  }

  @CheckReturnValue
  public UserId getUserId(String userId) {
    return new UserId(fromString(userId));
  }

  @CheckReturnValue
  public User getUser(String username, String email) {
    return getUser(new UserId(), username, email);
  }
}
