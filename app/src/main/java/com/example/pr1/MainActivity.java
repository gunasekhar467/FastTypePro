package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText uid,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uid=findViewById(R.id.uname);
        password=findViewById(R.id.passwd);
    }
    public void signup(View v)
    {
        if(password.getText().toString().length()>=8 &&
                validatepassword(password.getText().toString())) // For toast message
        {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_LONG).show();
// Length _long will remain 2 to 3 sec msg
            Intent i = new Intent(this, login.class);
            Bundle b = new Bundle();
            b.putString("u", uid.getText().toString());
            b.putString("p", password.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "SIGN UP fail", Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatepassword(String passwd) // Method define here bcz validateing
    {
        Pattern patt;
        Matcher match;
        String PASSWORDPATTERN="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*:;<>])(?=\\S+$).{8,}$";
        patt=Pattern.compile(PASSWORDPATTERN);
        match=patt.matcher(passwd);
        return match.matches();
    }
}
