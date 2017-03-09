package com.testproject.wellthyuserviewer.database;

import com.testproject.wellthyuserviewer.model.User;

import java.util.List;

/**
 * Created by prachi on 09/03/17.
 */

public interface UserRepositoryInterface {

    void saveDataToDevice(List<User> userList, UserRepositoryListener userRepositoryListener);

}
