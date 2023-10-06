package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class typetext extends AppCompatActivity {
    TextView result,result1,result2,character,word;
    EditText text;
    long start=0,end=0,start_sec=0,end_sec=0,speed=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typetext);
        text=findViewById(R.id.type_text);
        result=findViewById(R.id.res);
        result1=findViewById(R.id.res1);
        result2=findViewById(R.id.res2);
        character=findViewById(R.id.cha);
        word=findViewById(R.id.wor);
    }
    public void start(View v) {
        text.setText("");
        result.setText("");
        result1.setText("");
        result2.setText("");
        start=System.currentTimeMillis();
    }
    public void stop(View v) {
        end = System.currentTimeMillis();
        start_sec = start / 1000;
        end_sec = end / 1000;
        speed = end_sec - start_sec;
        long CharctersMin = ((35 * 60) / speed);//Accurately calculates the number of characters the user can type in a minute
        long WordsMin = ((9 * 60) / speed);//Accurately calculates the number of words the user can type in a minute
        String msg1 = "You have a good typing speed, welldone!!";
        String msg2 = "Well you have a average typing speed,which is good. You can still improve your typing speed by using keyboard.com, Goodluck!!";
        String msg3 = "Your typing speed is poor. You can increase your typing skills by using keyboard.com, Goodluck!!";
        String typingtext = "The Quick Brown Fox Jumps Over The Lazy Dog";
        if (text.getText().toString().equals(typingtext)) {
            result.setText("Great! You have correctly typed the above message.");
            result1.setText("Your typing speed is" + speed + "sec");
            if (speed <= 15) {
                result2.setText(msg1);
            }
            if (speed > 15 && speed < 23) {
                result2.setText(msg2);
            }
            if (speed > 23) {
                result2.setText(msg3);
            }
            character.setText("By your typing speed it is known that you type " + CharctersMin + " characters per minute.");
            word.setText("You type " + WordsMin + " words per minute");
        }
        if (!typingtext.equals( text.getText().toString())) {
            result.setText("You have incorrectly typed the above displayed sentence. Please retry by pressing the start button.");
        }
    }

}
