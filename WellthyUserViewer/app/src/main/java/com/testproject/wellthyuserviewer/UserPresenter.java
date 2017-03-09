package com.testproject.wellthyuserviewer;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public class UserPresenter implements UserPresenterInterface {

    MainViewInterface mainView;
    UserServiceInterface userServiceInterface;
    UserRepositoryInterface userRepositoryInterface;

    public UserPresenter(MainViewInterface mainView, UserServiceInterface userService){
        this.mainView = mainView;
        userServiceInterface = userService;
        userRepositoryInterface = new UserRepository(mainView.getAppContext());
    }

    @Override
    public void getUsers() {

        userServiceInterface.fetchDataFromServer(new UserDataListener() {
            @Override
            public void onSuccess(List<User> userList) {
                userRepositoryInterface.saveDataToDevice(userList, userRepositoryListener);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

        mainView.refreshList(null);
    }

    @Override
    public void showNoUsersError() {
        mainView.showNoUsersError();
    }

    private UserRepositoryListener userRepositoryListener = new UserRepositoryListener() {

        @Override
        public void onSuccess(List<User> userList) {
            mainView.refreshList(userList);
        }

        @Override
        public void onFailure(String errorMessage) {

        }
    };


}
