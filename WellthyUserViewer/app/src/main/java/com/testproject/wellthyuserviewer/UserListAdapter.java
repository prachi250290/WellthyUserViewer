package com.testproject.wellthyuserviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private List<User> userList;
    private Context context;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.mobileNumber.setText(user.getMobileNumber());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView name, mobileNumber;

        public UserViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.user_row_name_textView);
            mobileNumber = (TextView) view.findViewById(R.id.user_row_mobile_textView);

        }
    }
}