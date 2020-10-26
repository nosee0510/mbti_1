package com.example.pro_1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.pro_1.MessageActivity;
import com.example.pro_1.R;
import com.example.pro_1.Model.Users;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<Users> mUsers;
    private boolean isChat;
    private RequestManager mRequestManager;

    //Constructor
    public UserAdapter(Context context, List<Users> mUsers, Boolean isChat, RequestManager requestManager){
        this.context = context;
        this.mUsers = mUsers;
        this.isChat = isChat;
        mRequestManager= requestManager;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item,
                parent,
                false);

        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Users users = mUsers.get(position);
        holder.username.setText(users.getUsername());

        if(users.getImageURL().equals("default")){
            holder.imageView.setImageResource(R.mipmap.ic_launcher);

        }else{
            //Adding Glide Library
             mRequestManager
                    .load(users.getImageURL())
                    .circleCrop()
                    .into(holder.imageView);
        }


        //Status Check
        if (isChat){
            if(users.getStatus().equals("online")){
                holder.imageViewON.setVisibility(View.VISIBLE);
                holder.imageViewOFF.setVisibility(View.INVISIBLE);
                holder.textView_status.setVisibility(View.VISIBLE);
                holder.textView_status.setText("Online");

            }
            else{
                holder.imageViewON.setVisibility(View.INVISIBLE);
                holder.imageViewOFF.setVisibility(View.VISIBLE);
                holder.textView_status.setVisibility(View.VISIBLE);
                holder.textView_status.setText("Offline");
            }
        }else{
            holder.imageViewON.setVisibility(View.INVISIBLE);
            holder.imageViewOFF.setVisibility(View.INVISIBLE);
            holder.textView_status.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MessageActivity.class);
                i.putExtra("userid", users.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount(){
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView username;
        public ImageView imageView;
        public ImageView imageViewON;
        public ImageView imageViewOFF;
        public TextView textView_status;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            username=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView3);
            imageView.setBackground(new ShapeDrawable(new OvalShape()));
            imageView.setClipToOutline(true);
            imageViewON = itemView.findViewById(R.id.status_image_ON);
            imageViewOFF = itemView.findViewById(R.id.status_image_OFF);
            textView_status = itemView.findViewById(R.id.status_textView);

        }
    }
}
