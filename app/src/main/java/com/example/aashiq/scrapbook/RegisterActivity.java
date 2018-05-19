package com.example.aashiq.scrapbook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mDisplayName;
    private TextInputLayout mEmail;
    private TextInputLayout mpassword;
    private DatabaseReference mDatabase;

    private Button CreateAccount;
    private FirebaseAuth mAuth;
    private Toolbar mToolbar;

    //private ProgressBar mregprogress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        mDisplayName = (TextInputLayout) findViewById(R.id.name);
        mEmail = (TextInputLayout) findViewById(R.id.email);
        CreateAccount = (Button) findViewById(R.id.createAc);
        mpassword = (TextInputLayout) findViewById(R.id.pass);


        mToolbar = (Toolbar) findViewById(R.id.reg_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String display_name = mDisplayName.getEditText().getText().toString();
                String email = mEmail.getEditText().getText().toString();
                String password = mpassword.getEditText().getText().toString();

                register_user(display_name, email, password);






            }
        });




    }

    private void register_user(final String display_name, String email , String password){

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){



                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//                    //For Backbutton
//                    // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
//                    finish();




//                   FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
//
//                  String uid = current_user.getUid();
//
//                  mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
//
//                    HashMap<String, String> userMap = new HashMap<>();
//                    userMap.put("name",display_name);
//                    userMap.put("status", "Hi there this is aash");
//                    userMap.put("image", "default");
//
//
//                    mDatabase.setValue(userMap);
////
//                    mDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if(task.isSuccessful()){
//
//                               // mregprogress.dismiss();
//
//                                Intent intent = new Intent(regActivity.this, MainActivity.class);
//
//                                //For Backbutton
//                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                startActivity(intent);
//                                finish();
//
//
////
//                            }
//                        }
//                    });

//
//
//                }
//                else{
//
//                    mregprogress.hide();
//
//                    Toast.makeText(regActivity.this,"Can not Sign In. Please Check The Form And Try Again",Toast.LENGTH_LONG).show();
                }

                else
                    Toast.makeText(RegisterActivity.this,"Can not Sign In. Please Check The Form And Try Again",Toast.LENGTH_LONG).show();

            }
        });



    }




}
