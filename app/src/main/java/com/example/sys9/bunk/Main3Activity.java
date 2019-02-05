package com.example.sys9.bunk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity {

    EditText Firstname;
    EditText Lastname;
    EditText Emailid;
    EditText Password;
    EditText Confirmpassword;
    TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );


        Firstname = findViewById( R.id.fname );
        Lastname = findViewById( R.id.lname );
        Emailid = findViewById( R.id.email );
        Password = findViewById( R.id.pwd );
        Confirmpassword = findViewById( R.id.cpwd );
        submit = findViewById( R.id.sub );

        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent( getApplicationContext(),Main2Activity.class );
                startActivity( i );
                checkDataEntered();
            }
        } );
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty( email ) && Patterns.EMAIL_ADDRESS.matcher( email ).matches());

    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty( str );
    }

    void checkDataEntered() {
        if (isEmpty( Firstname )) {
            Toast t = Toast.makeText( this, "Enter Your First name", Toast.LENGTH_LONG );
            t.show();
        }

        if (isEmpty( Lastname )) {
            Lastname.setError( "Enter your Last name" );
        }

        if (isEmpty( Emailid )) {
            Emailid.setError( "Enter your Email id" );
        }

        if (isEmpty( Password )) {
            Password.setError( "Enter your password" );
        }

        if (isEmpty( Confirmpassword )) {
            Confirmpassword.setError( "Enter your confirmation password" );

            if (!Confirmpassword.equals( Confirmpassword )) {
                Toast.makeText( this, "Password do not match", Toast.LENGTH_SHORT ).show();
            }
        }
    }
}
