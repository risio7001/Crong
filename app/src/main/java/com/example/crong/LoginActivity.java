package com.example.crong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login).setOnClickListener(onclickListener);


    }

    @SuppressLint("NonConstantResourceId")
    View.OnClickListener onclickListener = v -> {
      switch(v.getId()){
          case R.id.btn_login:
              String id = ((EditText) findViewById(R.id.et_id)).toString();
              String pw = ((EditText) findViewById(R.id.et_pw)).toString();
              Login(id, pw);
              Toast.makeText(this, "로그인", Toast.LENGTH_SHORT).show();
              break;
          case R.id.btn_forgot:
              Toast.makeText(this, "찾기", Toast.LENGTH_SHORT).show();
              break;
          case R.id.btn_signUp:
              Toast.makeText(this, "회원가입", Toast.LENGTH_SHORT).show();
              break;
      }
    };

    public void Login(String id, String pw){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(id, pw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "로그인 실패.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            // ...
                        }

                        // ...
                    }
                });

    }
}