package com.testproject.wellthyuserviewer;

/**
 * Created by prachi on 05/03/17.
 */

public class UserPresenter implements UserPresenterInterface {

    MainViewInterface mainView;
    UserServiceInterface userServiceInterface;

    public UserPresenter(MainViewInterface mainView){
        this.mainView = mainView;
        userServiceInterface = new UserService();
    }

    @Override
    public void getUsers() {

        userServiceInterface.fetchDataFromServer();

        mainView.refreshList(null);
    }
}
