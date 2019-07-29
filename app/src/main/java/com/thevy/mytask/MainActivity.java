package com.thevy.mytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Main Activity", "Start Login Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });

    }

    private void clickLogin() {
        Log.d("MainActiviy", "Click Login");
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        //link to firebase
        if (username.equals("kiten9e") && password.equals("03101997")){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
