package com.testproject.wellthyuserviewer.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.testproject.wellthyuserviewer.R;
import com.testproject.wellthyuserviewer.model.User;
import com.testproject.wellthyuserviewer.presenter.UserPresenter;
import com.testproject.wellthyuserviewer.presenter.UserPresenterInterface;
import com.testproject.wellthyuserviewer.webservice.UserService;

import java.util.List;

public class MainActivity extends Activity implements MainViewInterface {

    private RecyclerView recyclerView;
    private UserListAdapter userListAdapter;
    private LinearLayoutManager mLayoutManager;

    private UserPresenterInterface userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializeList();

        userPresenter = new UserPresenter(this, new UserService());

        fetchUsers();

    }

    private void initializeList() {

        recyclerView = (RecyclerView) findViewById(R.id.userListView);

        userListAdapter = new UserListAdapter(this);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(userListAdapter);

    }


    public void fetchUsers() {
        userPresenter.getUsers();
    }

    @Override
    public void refreshList(List<User> userList) {
        userListAdapter.setUserList(userList);
        userListAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public void showNoUsersError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No Users found");
        builder.create().show();
    }
}
