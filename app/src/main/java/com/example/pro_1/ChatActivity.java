package com.example.pro_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Hashtable;

public class ChatActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    EditText etText = findViewById(R.id.etText);
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        findViewById(R.id.btnSend).setOnClickListener(onClickListener);
        findViewById(R.id.btnFinish).setOnClickListener(onClickListener);

        email = getIntent().getStringExtra("email");
        recyclerView = (RecyclerView) findViewById(R.id.chatRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        String[] myDataset = {"test1","test2","test3","test4"};
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnFinish:
                    finish();
                    break;
                case R.id.btnSend:
                    chat();
            }
        }
    };

    private void chat() {
        String stText = etText.getText().toString();
        Toast.makeText(ChatActivity.this, "MSG : " + stText, Toast.LENGTH_LONG).show();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        Hashtable<String, String> numbers
                = new Hashtable<String, String>();
        numbers.put("email",email);
        numbers.put("two",stText);
        myRef.setValue(numbers);
    }


}


