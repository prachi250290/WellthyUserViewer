package com.testproject.wellthyuserviewer.views;

import android.content.Context;

import com.testproject.wellthyuserviewer.model.User;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public interface MainViewInterface {

    void refreshList(List<User> users);

    Context getAppContext();

    void showNoUsersError();

}
