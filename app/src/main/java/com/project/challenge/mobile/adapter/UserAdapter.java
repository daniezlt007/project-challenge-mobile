package com.project.challenge.mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.challenge.mobile.R;
import com.project.challenge.mobile.model.StatusUse;
import com.project.challenge.mobile.model.User;
import com.project.challenge.mobile.viewholder.UserViewHolder;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<StatusUse> mList;
    public UserAdapter(List<StatusUse> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        StatusUse uses = this.mList.get(position);
        holder.bind(uses);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
