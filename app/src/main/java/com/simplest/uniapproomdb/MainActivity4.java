package com.simplest.uniapproomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView txt;
    Button btn;
    String info;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txt = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);

        Intent intent = getIntent();
        info = intent.getStringExtra("Name");
        txt.setText(info);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity4.this);
                progressDialog.setTitle("Please Wait");
                progressDialog.setMessage("Downloading Certificate");
                progressDialog.show();
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
