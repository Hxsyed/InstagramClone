package com.example.insta;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";
    private EditText signupname;
    private EditText signuppass1;
    private EditText signuppass2;
    private Button signupbutton;
    ParseUser user = new ParseUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ActionBar bar = getSupportActionBar();
        bar.hide();

        signupname = findViewById(R.id.signupname);
        signuppass1 = findViewById(R.id.signuppass1);
        signuppass2 = findViewById(R.id.signuppass2);
        signupbutton = findViewById(R.id.signupbutton);

        signupbutton.setBackgroundColor(Color.GREEN);
        signupbutton.setTextColor(Color.WHITE);


        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = signupname.getText().toString();
                String sign1 = signuppass1.getText().toString();
                String sign2 = signuppass2.getText().toString();
                if (sign1 != sign2) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
                submit(username, sign1);
            }
        });
    }

    private void submit(String username, String sign1) {
        user.setUsername(username);
        user.setPassword(sign1);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    goMainActivity();
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Log.e(TAG,"Issue with Signup",e);
                    return;
                }
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
