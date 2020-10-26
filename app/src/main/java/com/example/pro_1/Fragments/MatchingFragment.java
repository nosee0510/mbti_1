package com.example.pro_1.Fragments;
import com.example.pro_1.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro_1.enfjj;
import com.example.pro_1.enfpp;
import com.example.pro_1.entjj;
import com.example.pro_1.entpp;
import com.example.pro_1.esfjj;
import com.example.pro_1.esfpp;
import com.example.pro_1.estjj;
import com.example.pro_1.estpp;
import com.example.pro_1.infjj;
import com.example.pro_1.infpp;
import com.example.pro_1.intjj;
import com.example.pro_1.intpp;
import com.example.pro_1.isfjj;
import com.example.pro_1.isfpp;
import com.example.pro_1.istjj;
import com.example.pro_1.istpp;


import java.util.ArrayList;

public class MatchingFragment extends Fragment {
    private Button button;
    private View view;
    private Spinner spinner;
    private ArrayList arrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_matching, container, false);


        arrayList = new ArrayList();
        arrayList.add("ISTJ");
        arrayList.add("INFJ");
        arrayList.add("ISFJ");
        arrayList.add("INTJ");
        arrayList.add("ISTP");
        arrayList.add("ISTP");
        arrayList.add("ISFP");
        arrayList.add("INFP");
        arrayList.add("INTP");
        arrayList.add("ESTP");
        arrayList.add("ESFP");
        arrayList.add("ENTP");
        arrayList.add("ENFP");
        arrayList.add("ESTJ");
        arrayList.add("ESFJ");
        arrayList.add("ENFJ");
        arrayList.add("ENTJ");


        final String[] select_item = {""};


        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_spinner_item, arrayList);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        Button button = (Button) view.findViewById(R.id.button_type);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                select_item[0] = String.valueOf(arrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        button.setOnClickListener(new View.OnClickListener() {

            // 요청을 보내야 하는데 메인 액티비티에 다가 메소드를 하나 만들어야 한다.
            public void onClick(View view) {
                if (select_item[0].equals("ISTJ")) {
                    Intent intent = new Intent(getActivity(), istjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("INFJ")) {
                    Intent intent = new Intent(getActivity(), infjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ISFJ")) {
                    Intent intent = new Intent(getActivity(), isfjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("INTJ")) {
                    Intent intent = new Intent(getActivity(), intjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ISTP")) {
                    Intent intent = new Intent(getActivity(), istpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ISFP")) {
                    Intent intent = new Intent(getActivity(), isfpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("INFP")) {
                    Intent intent = new Intent(getActivity(), infpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("INTP")) {
                    Intent intent = new Intent(getActivity(), intpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ESTP")) {
                    Intent intent = new Intent(getActivity(), estpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ESFP")) {
                    Intent intent = new Intent(getActivity(), esfpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ENTP")) {
                    Intent intent = new Intent(getActivity(), entpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ENFP")) {
                    Intent intent = new Intent(getActivity(), enfpp.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ESTJ")) {
                    Intent intent = new Intent(getActivity(), estjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ESFJ")) {
                    Intent intent = new Intent(getActivity(), esfjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ENFJ")) {
                    Intent intent = new Intent(getActivity(), enfjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (select_item[0].equals("ENTJ")) {
                    Intent intent = new Intent(getActivity(), entjj.class);
                    Toast.makeText(getContext(), "궁합창으로 이동중입니다", Toast.LENGTH_LONG).show();
                    startActivity(intent);

                }
            }
        });

        return view;
    }
}