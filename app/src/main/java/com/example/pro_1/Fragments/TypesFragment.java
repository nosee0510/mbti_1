package com.example.pro_1.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro_1.MBTI_Types.enfj;
import com.example.pro_1.MBTI_Types.enfp;
import com.example.pro_1.MBTI_Types.entj;
import com.example.pro_1.MBTI_Types.entp;
import com.example.pro_1.MBTI_Types.esfj;
import com.example.pro_1.MBTI_Types.esfp;
import com.example.pro_1.MBTI_Types.estj;
import com.example.pro_1.MBTI_Types.estp;
import com.example.pro_1.MBTI_Types.infj;
import com.example.pro_1.MBTI_Types.infp;
import com.example.pro_1.MBTI_Types.intj;
import com.example.pro_1.MBTI_Types.intp;
import com.example.pro_1.MBTI_Types.isfj;
import com.example.pro_1.MBTI_Types.isfp;
import com.example.pro_1.MBTI_Types.istj;
import com.example.pro_1.MBTI_Types.istp;
import com.example.pro_1.R;

public class TypesFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_types, container, false);

        Button btnENFP = view.findViewById(R.id.ENFP);
        btnENFP.setOnClickListener(new View.OnClickListener() {
            // 요청을 보내야 하는데 메인 액티비티에 다가 메소드를 하나 만들어야 한다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), enfp.class);
                startActivity(intent);
            }
        });

        Button btnISTJ = view.findViewById(R.id.ISTJ);
        btnISTJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), istj.class);
                startActivity(intent);
            }
        });

        Button btnISFJ = view.findViewById(R.id.ISFJ);
        btnISFJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), isfj.class);
                startActivity(intent);
            }
        });

        Button btnINFJ = view.findViewById(R.id.INFJ);
        btnINFJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), infj.class);
                startActivity(intent);
            }
        });

        Button btnINTJ = view.findViewById(R.id.INTJ);
        btnINTJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), intj.class);
                startActivity(intent);
            }
        });

        Button btnISTP = view.findViewById(R.id.ISTP);
        btnISTP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), istp.class);
                startActivity(intent);
            }
        });

        Button btnISFP = view.findViewById(R.id.ISFP);
        btnISFP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), isfp.class);
                startActivity(intent);
            }
        });

        Button btnINFP = view.findViewById(R.id.INFP);
        btnINFP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), infp.class);
                startActivity(intent);
            }
        });

        Button btnINTP = view.findViewById(R.id.INTP);
        btnINTP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), intp.class);
                startActivity(intent);
            }
        });

        Button btnESTP = view.findViewById(R.id.ESTP);
        btnESTP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), estp.class);
                startActivity(intent);
            }
        });

        Button btnESFP = view.findViewById(R.id.ESFP);
        btnESFP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), esfp.class);
                startActivity(intent);
            }
        });

        Button btnENTP = view.findViewById(R.id.ENTP);
        btnENTP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), entp.class);
                startActivity(intent);
            }
        });

        Button btnESTJ = view.findViewById(R.id.ESTJ);
        btnESTJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), estj.class);
                startActivity(intent);
            }
        });

        Button btnENFJ = view.findViewById(R.id.ENFJ);
        btnENFJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), enfj.class);
                startActivity(intent);
            }
        });

        Button btnENTJ = view.findViewById(R.id.ENTJ);
        btnENTJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), entj.class);
                startActivity(intent);
            }
        });

        Button btnESFJ = view.findViewById(R.id.ESFJ);
        btnESFJ.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), esfj.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(getActivity(), c);
        startActivityForResult(intent, 0);
    }
}