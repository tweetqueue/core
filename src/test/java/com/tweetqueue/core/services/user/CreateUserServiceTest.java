package com.tweetqueue.core.services.user;

import com.tweetqueue.core.model.user.User;
import com.tweetqueue.core.model.user.UserFactory;
import com.tweetqueue.core.model.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateUserServiceTest {

  private static final String EMAIL = "email";

  private static final String USER = "user";

  private CreateUserService createUserService;

  @Mock private UserRepository userRepository;

  @Mock private UserFactory userFactory;

  @Mock private UserResponseFactory userResponseFactory;

  @Mock private CreateUserRequest createUserRequest;

  @Mock private UserResponse userResponse;

  @Mock private User user;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    createUserService = new CreateUserService(userRepository, userFactory, userResponseFactory);
  }

  @Test
  public void itCreateANewUser() {

    when(createUserRequest.getUsername()).thenReturn(USER);
    when(createUserRequest.getEmail()).thenReturn(EMAIL);
    when(userFactory.getUser(USER, EMAIL)).thenReturn(user);
    when(userRepository.save(user)).thenReturn(user);
    when(userResponseFactory.getUserResponse(user)).thenReturn(userResponse);

    assertThat(createUserService.createUser(createUserRequest), is(userResponse));
    verify(userRepository, times(1)).save(user);
  }
}
