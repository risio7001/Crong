package com.example.crong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import Info.member;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<member> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);



        findViewById(R.id.btn_send).setOnClickListener(onclickListener);

//        recyclerView.setAdapter(adapter);

    }

    View.OnClickListener onclickListener = v -> {
      switch (v.getId()){
          case R.id.btn_send:

              EditText send_Text = findViewById(R.id.send_text);
              send_Text.getText();
              Toast.makeText(this, "text : "+ send_Text.getText() , Toast.LENGTH_SHORT).show();
              sendText(send_Text);
              break;
      }
    };
    public void sendText(EditText send_Text){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Message");

        myRef.setValue(send_Text.getText().toString());
    }
}