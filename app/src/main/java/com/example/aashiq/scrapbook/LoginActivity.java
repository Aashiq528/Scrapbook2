package com.example.aashiq.scrapbook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Toolbar mToolbar;


    private FirebaseAuth mAuth;




    private TextInputLayout mloginEmail;
    private TextInputLayout mloginpassword;
    private Button mlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mAuth = FirebaseAuth.getInstance();

        mloginEmail = (TextInputLayout) findViewById(R.id.email);
        mlogin = (Button) findViewById(R.id.login);
        mloginpassword = (TextInputLayout) findViewById(R.id.pass);


        mToolbar = (Toolbar) findViewById(R.id.log_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Login Now");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mloginEmail.getEditText().getText().toString();
                String password = mloginpassword.getEditText().getText().toString();

                lognUser(email, password);

//                if (!TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
//
//                    mlogprogress.setTitle("Logging In");
//                    mlogprogress.setMessage("Please wait While Login");
//                    mlogprogress.setCanceledOnTouchOutside(false);
//                    mlogprogress.show();
//
//
//                    lognUser(email,password);
//
//                }
//
//            }
//
//        });


            }

        });



    }

    private void lognUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful()){


                    Intent intent = new Intent(LoginActivity.this, MainActivity.class); // To go another Activity

                    startActivity(intent);



                }
                else{


                    Toast.makeText(LoginActivity.this,"Can not Sign In. Please Check The Form And Try Again",Toast.LENGTH_LONG).show();
                }



            }
        });


    }


}


