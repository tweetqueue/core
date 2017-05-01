package com.tweetqueue.core.model.user;

public interface UserRepository {
  User getById(UserId userId);

  User save(User user);

  User remove(User user);
}
