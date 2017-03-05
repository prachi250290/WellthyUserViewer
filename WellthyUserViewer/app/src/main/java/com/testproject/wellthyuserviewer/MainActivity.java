package com.testproject.wellthyuserviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends Activity implements MainViewInterface {

    private RecyclerView recyclerView;
    private UserListAdapter userListAdapter;
    private LinearLayoutManager mLayoutManager;;

    private UserPresenterInterface userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializeList();


        userPresenter = new UserPresenter(this);

        fetchUsers();

    }

    private void initializeList() {

        recyclerView = (RecyclerView) findViewById(R.id.userListView);

        userListAdapter = new UserListAdapter(this);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
}
