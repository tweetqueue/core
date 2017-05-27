package com.tweetqueue.core.services.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;

import com.tweetqueue.core.model.user.User;
import com.tweetqueue.core.model.user.UserId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserResponseFactoryTest {
  private static final String USER_NAME = "name";

  private UserResponseFactory userResponseFactory;

  @Mock
  private User user;

  @Mock
  private UserId userId;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    userResponseFactory = new UserResponseFactory();
  }

  @Test
  public void itIsPossibleToGenerateAResponseFromAnUser() {
    when(user.getId()).thenReturn(userId);
    when(user.getUsername()).thenReturn(USER_NAME);

    assertThat(userResponseFactory.getUserResponse(user), instanceOf(UserResponse.class));
  }
}