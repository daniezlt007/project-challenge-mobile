package com.project.challenge.mobile.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.challenge.mobile.R;
import com.project.challenge.mobile.model.StatusUse;

public class UserViewHolder extends RecyclerView.ViewHolder{

    private TextView mTxtAproved;
    private ImageView mImageViewApproved;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mTxtAproved = itemView.findViewById(R.id.txt_aproved);
        this.mImageViewApproved = itemView.findViewById(R.id.imageViewApproved);

    }

    public void bind(StatusUse statusUse){
        this.mTxtAproved.setText(String.valueOf(statusUse.getLabel()));
        this.mImageViewApproved.setImageResource(statusUse.getChecked() ? R.drawable.ic_checkmark : R.drawable.ic_componente_6___1);
    }
}
