package com.testproject.wellthyuserviewer;

/**
 * Created by prachi on 05/03/17.
 */

public interface UserServiceInterface {

    void fetchDataFromServer(UserDataListener userDataListener);

    void saveDataToDevice();
}
