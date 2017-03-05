package com.testproject.wellthyuserviewer;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public interface UserDataListener {

        void onSuccess(List<User> userList);

        void onFailure(String errorMessage);

}
