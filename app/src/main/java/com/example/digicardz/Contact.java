package com.example.digicardz;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Contact extends AppCompatActivity {
    private EditText fnametxt;
    private EditText lnametxt;
    private EditText emailidtxt;
    private EditText phno;
    private EditText msgtxt;
    private Button sendbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setIcon(R.drawable.mainlogo);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Contact.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Subjects));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        fnametxt=findViewById(R.id.fnametxt);
        lnametxt=findViewById(R.id.lnametxt);
        emailidtxt=findViewById(R.id.emailidtxt);
        phno=findViewById(R.id.phnno);
        msgtxt=findViewById(R.id.msgtxt);
        sendbtn=findViewById(R.id.sendbtn);


        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FirstName = fnametxt.getText().toString();
                String LastName = lnametxt.getText().toString();
                String EmailId = emailidtxt.getText().toString();
                String MobileNumber = phno.getText().toString();
                String Message = msgtxt.getText().toString();
                String Send = sendbtn.getText().toString();

                boolean check = validateinfo(FirstName, LastName, EmailId, MobileNumber, Message, Send);

                if (check == true) {
                    Toast.makeText(getApplicationContext(), "Data is valid", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry check for Information", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }


    private boolean validateinfo (String firstName, String lastName, String emailId, String mobileNumber, String message, String send)
    {
        if (firstName.length() == 0) {
            fnametxt.requestFocus();
            fnametxt.setError("FIELD CANNOT BE EMPTY");
            return false;
        } else if (!firstName.matches("[a-zA-Z]+")) {
            fnametxt.requestFocus();
            fnametxt.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        }
        if (lastName.length() == 0) {
            lnametxt.requestFocus();
            lnametxt.setError("FIELD CANNOT BE EMPTY");
            return false;
        } else if (!lastName.matches("[a-zA-Z]+")) {
            lnametxt.requestFocus();
            lnametxt.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        } else if (emailId.length() == 0) {
            emailidtxt.requestFocus();
            emailidtxt.setError("FIELD CANNOT BE EMPTY");
            return false;
        } else if (!emailId.matches("[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            emailidtxt.requestFocus();
            emailidtxt.setError("ENTER VALID EMAIL");
            return false;
        } else if (mobileNumber.length() == 0) {
            phno.requestFocus();
            phno.setError("FIELD CANNOT BE EMPTY");
            return false;
        } else if (!mobileNumber.matches("^[+][0-9]{10,13}$")) {
            phno.requestFocus();
            phno.setError("correct Format: +91xxxxxxxxxx");
            return false;
        } else {
            return true;
        }
    }
}
