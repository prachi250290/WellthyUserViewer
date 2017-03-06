package com.testproject.wellthyuserviewer;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public interface UserServiceInterface {

    void fetchDataFromServer(UserDataListener userDataListener);

    void saveDataToDevice(List<User> userList, UserDataListener userDataListener);
}
