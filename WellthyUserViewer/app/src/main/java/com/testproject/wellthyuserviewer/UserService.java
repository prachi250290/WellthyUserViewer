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

    public UserService () {

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
                        userDataListener.onSuccess(users);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                userDataListener.onFailure(t.toString());

            }
        });
    }



}
