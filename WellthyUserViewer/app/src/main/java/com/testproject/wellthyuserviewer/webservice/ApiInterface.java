package com.testproject.wellthyuserviewer.webservice;

import com.testproject.wellthyuserviewer.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by prachi on 05/03/17.
 */

public interface ApiInterface {

    @GET("/users")
    Call<List<User>> getUsers();

}
