package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class login extends AppCompatActivity {
    EditText uid,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uid=findViewById(R.id.uname);
        password=findViewById(R.id.passwd);
    }
    public void signin(View v)
    {
        String u,p;
        Bundle b=getIntent().getExtras(); //geting bunddel from intent and getextras
        u=b.getString( "u") ;// key is from main activity u and p
        p=b.getString( "p");
        if(u.equals(uid.getText().toString()) && p.equals((password.getText().toString())))
        {
            Toast.makeText(this, "SIGN in success", Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,typing.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this,"Login failed",Toast.LENGTH_LONG).show();
        }
    }
}
