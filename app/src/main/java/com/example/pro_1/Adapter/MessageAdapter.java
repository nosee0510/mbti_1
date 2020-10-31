package com.example.pro_1.Adapter;

import android.content.Context;
import android.graphics.drawable.shapes.OvalShape;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pro_1.Model.Chat;
import com.example.pro_1.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private Context context;
    private List<Chat> mChat;
    private String imageURL;

    FirebaseUser firebaseUser;
    FirebaseDatabase reference;



    public static final int MSG_TYPE_LEFT =0;
    public static final int MSG_TYPE_RIGHT =1;

    //Constructor
    public MessageAdapter(Context context, List<Chat> mChat, String imageURL){
        this.context = context;
        this.mChat = mChat;
        this.imageURL = imageURL;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == MSG_TYPE_RIGHT) {

            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_right,
                    parent,
                    false);

            return new MessageAdapter.ViewHolder(view);
        }else{
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_left,
                    parent,
                    false);

            return new MessageAdapter.ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {

        Chat chat = mChat.get(position);
        String timeStamp = chat.getTimestamp();
        Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.setTimeInMillis(Long.parseLong(timeStamp));
        String dateTime = DateFormat.format("dd/MM/yyyy hh:mm aa", cal).toString();

        holder.show_message.setText(chat.getMessage());
        holder.show_timer.setText(dateTime);


        if (imageURL.equals("default")) {
            holder.profile_image.setImageResource(R.drawable.user_icon);
        } else {
            Glide.with(context).load(imageURL).circleCrop().into(holder.profile_image);
        }

        if (position == mChat.size() - 1) {
            if (chat.isSeen()) {
                holder.isSeen.setText("읽음");
            } else {
                holder.isSeen.setText("전송됨");
            }

        } else {
            holder.isSeen.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount(){
        return mChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView show_message;
        public ImageView profile_image;
        public TextView show_timer;
        public TextView isSeen;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            show_timer=itemView.findViewById(R.id.show_timer);
            show_message=itemView.findViewById(R.id.show_message);
            profile_image=itemView.findViewById(R.id.profile_image);
            isSeen=itemView.findViewById(R.id.isSeen);
        }
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mChat.get(position).getSender().equals(firebaseUser.getUid())){
            return MSG_TYPE_RIGHT;
        }else{
            return MSG_TYPE_LEFT;
        }
    }
}
