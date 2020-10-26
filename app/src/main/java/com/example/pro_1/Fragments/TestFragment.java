package com.example.pro_1.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro_1.R;
import com.example.pro_1.test1;

public class TestFragment extends Fragment {
    private View view;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_test, container, false);


        Button button = (Button) view.findViewById(R.id.testBtn);
        button.setOnClickListener(new View.OnClickListener() {
            // 요청을 보내야 하는데 메인 액티비티에 다가 메소드를 하나 만들어야 한다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), test1.class);
                Toast.makeText(getContext(), "검사창으로 이동중입니다", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });


        return view;
    }


}