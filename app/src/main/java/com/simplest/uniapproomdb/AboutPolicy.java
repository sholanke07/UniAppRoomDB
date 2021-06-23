package com.simplest.uniapproomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutPolicy extends AppCompatActivity {
TextView aboutpolicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_policy);
        aboutpolicy = (TextView)findViewById(R.id.aboutpolicy);

        aboutpolicy.setText("About Universal Insurance Plc 24 hours travelling insurance policy");
    }
}