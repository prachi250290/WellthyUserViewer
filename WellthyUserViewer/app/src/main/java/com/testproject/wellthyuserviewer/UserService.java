package com.testproject.wellthyuserviewer;

import android.content.Context;

import com.testproject.wellthyuserviewer.database.UserInfoDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prachi on 05/03/17.
 */

public class UserService implements UserServiceInterface {


    private UserInfoDataSource userInfoDataSource;

    public UserService (Context context){
        userInfoDataSource = new UserInfoDataSource(context);
    }


    @Override
    public void fetchDataFromServer(final UserDataListener userDataListener) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        Call<List<User>> call = apiService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response != null) {
                    if (response.isSuccessful()) {

                        List<User> users = response.body();
                        saveDataToDevice(users, userDataListener);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                userDataListener.onFailure(t.toString());

            }
        });
    }

    @Override
    public void saveDataToDevice(List<User> userList, UserDataListener userDataListener) {
       boolean isDataSaved = userInfoDataSource.saveAllUsers(userList);
        if(isDataSaved) {
            userDataListener.onSuccess(userInfoDataSource.getAllUsers());
        }
    }



}
