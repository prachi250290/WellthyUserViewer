package com.testproject.wellthyuserviewer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class UserPresenterTest {

    @Mock
    private MainViewInterface mainView;
    private UserServiceInterface userService;

    @Mock
    private UserPresenter userPresenter;

    @Before
    public void setup() throws Exception {
        userService = new UserService();
    }

    @Test
    public void areUsersPresent() throws Exception {

        userService.fetchDataFromServer(new UserDataListener() {
            @Override
            public void onSuccess(List<User> userList) {
                assertNotEquals(userList.size(), 0);
                userPresenter.showNoUsersError();
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });



    }


}