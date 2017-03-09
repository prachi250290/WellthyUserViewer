package com.testproject.wellthyuserviewer.database;

import android.content.Context;

import com.testproject.wellthyuserviewer.model.User;

import java.util.List;

/**
 * Created by prachi on 09/03/17.
 */

public class UserRepository implements UserRepositoryInterface {

    private UserInfoDataSource userInfoDataSource;

    public UserRepository(Context context) {
        userInfoDataSource = new UserInfoDataSource(context);
    }

    @Override
    public void saveDataToDevice(List<User> userList, UserRepositoryListener userRepositoryListener) {
            boolean isDataSaved = userInfoDataSource.saveAllUsers(userList);
            if(isDataSaved) {
                userRepositoryListener.onSuccess(userInfoDataSource.getAllUsers());
            }
    }
}
