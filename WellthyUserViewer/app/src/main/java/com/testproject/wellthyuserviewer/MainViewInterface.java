package com.testproject.wellthyuserviewer;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public interface MainViewInterface {

    void fetchUsers();

    void refreshList(List<User> users);

}
