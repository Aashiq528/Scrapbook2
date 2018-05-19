package com.example.aashiq.scrapbook;

import android.content.Intent;
import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button mreg;
    private Button mlog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mreg = (Button) findViewById(R.id.sign);
        mlog = (Button) findViewById(R.id.login);

        mreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        mlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kk = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(kk);
            }
        });




    }
}
