package com.testproject.wellthyuserviewer;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public class UserPresenter implements UserPresenterInterface {

    MainViewInterface mainView;
    UserServiceInterface userServiceInterface;

    public UserPresenter(MainViewInterface mainView){
        this.mainView = mainView;
        userServiceInterface = new UserService(mainView.getAppContext());
    }

    @Override
    public void getUsers() {

        userServiceInterface.fetchDataFromServer(new UserDataListener() {
            @Override
            public void onSuccess(List<User> userList) {
                mainView.refreshList(userList);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

        mainView.refreshList(null);
    }
}
