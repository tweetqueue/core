package com.tweetqueue.core.model.user;

import java.util.Optional;

public interface UserRepository {

  Optional<User> getById(UserId userId);

  User save(User user);

  User remove(User user);
}
