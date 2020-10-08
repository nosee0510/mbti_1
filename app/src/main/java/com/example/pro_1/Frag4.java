package com.example.pro_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.BatchUpdateException;

public class Frag4 extends Fragment {
    private View view;
    private Button btnChat;
    MainActivity activity;
    public interface Fragment4Listener{

    }


    public Frag4() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag4, container, false);
        btnChat = v.findViewById(R.id.checkButton);
        btnChat.setOnClickListener(new View.OnClickListener() {
            // 요청을 보내야 하는데 메인 액티비티에 다가 메소드를 하나 만들어야 한다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }





}