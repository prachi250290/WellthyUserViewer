package com.testproject.wellthyuserviewer;

import android.content.Context;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public interface MainViewInterface {

    void refreshList(List<User> users);

    Context getAppContext();

}
