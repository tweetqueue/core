package com.tweetqueue.core.services.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tweetqueue.core.model.user.User;
import com.tweetqueue.core.model.user.UserFactory;
import com.tweetqueue.core.model.user.UserId;
import com.tweetqueue.core.model.user.UserRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class GetUserProfileTest {

  private static final String ID = "id";

  private GetUserProfile getUserProfile;

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserFactory userFactory;

  @Mock
  private UserResponseFactory userResponseFactory;

  @Mock
  private GetUserRequest getUserRequest;

  @Mock
  private UserId userId;

  @Mock
  private User user;

  @Mock
  private UserResponse userResponse;


  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    getUserProfile = new GetUserProfile(userRepository, userFactory, userResponseFactory);
  }

  @Test
  public void getAnExistingUserProfile() {
    givenAUserRequestToGetAProfile();
    andGeneratesAndUserResponse();
    when(userRepository.getById(userId)).thenReturn(Optional.ofNullable(user));

    assertThat(getUserProfile.getUserProfileById(getUserRequest), is(userResponse));
    verify(userResponseFactory, times(1))
        .getUserResponse(user);
    verify(userFactory, never()).getUser(null, null);

  }

  @Test
  public void getNonExistingUserProfile() {
    givenAUserRequestToGetAProfile();
    andGeneratesAndUserResponse();
    when(userRepository.getById(userId)).thenReturn(Optional.empty());
    when(userFactory.getUser(null, null)).thenReturn(user);

    assertThat(getUserProfile.getUserProfileById(getUserRequest), is(userResponse));
    verify(userResponseFactory, times(1))
        .getUserResponse(user);
    verify(userFactory, times(1)).getUser(null, null);
  }

  private void givenAUserRequestToGetAProfile() {
    when(getUserRequest.getId()).thenReturn(ID);
    when(userFactory.getUserId(ID)).thenReturn(userId);
  }

  private void andGeneratesAndUserResponse() {
    when(userResponseFactory.getUserResponse(user)).thenReturn(userResponse);
  }
}