package com.example.testtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1, ed2;
    Button loginb;
    String user = "user1";
    String pass = "password1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.useredit);
        ed2 = findViewById(R.id.passedit);

        loginb = findViewById(R.id.loginbutton);
        loginb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(!(ed1.getText().toString().equalsIgnoreCase(user))){
            Toast.makeText(MainActivity.this, "Invaild UserName Try Again! ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!(ed2.getText().toString().equalsIgnoreCase(pass))){
            Toast.makeText(MainActivity.this, "Invaild Password ", Toast.LENGTH_SHORT).show();
            return;
        }
        else {


            Intent intent = new Intent(MainActivity.this, Main2Activity.class);

            startActivity(intent);
        }
    }



}