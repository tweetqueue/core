package com.tweetqueue.core.services.user;


import com.tweetqueue.core.model.user.User;

public class UserResponseFactory {

    public UserResponse getUserResponse(User user) {
        return new UserResponse(user.getId().toString(), user.getUsername());
    }
}
