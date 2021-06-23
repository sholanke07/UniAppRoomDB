package com.simplest.uniapproomdb;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    Button accept;
    TextView txt;
    TextInputLayout edit;
    String amot, travel;
    String name_name, email_email, FROM, TO, address_address, phone_phone, model_model, reg_reg, color_color, Num;
    String OTP;
    ProgressDialog progressDialog;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt = (TextView) findViewById(R.id.txt);
        accept = (Button) findViewById(R.id.btn);
        edit = (TextInputLayout) findViewById(R.id.otp);

        SharedPreferences sp = getSharedPreferences("Key", MODE_PRIVATE);
        name_name = sp.getString("username", " ");
        email_email = sp.getString("email", " ");
        FROM = sp.getString("from", " ");
        TO = sp.getString("to", " ");
        address_address = sp.getString("address", " ");
        phone_phone = sp.getString("phone", " ");
        model_model = sp.getString("model", " ");
        reg_reg = sp.getString("Number", " ");
        color_color = sp.getString("color", " ");
        amot = sp.getString("Price", " ");
        travel = sp.getString("travel", " ");
        //Num = sp.getString("Number", " ");


        Intent intent = getIntent();
        txt.setText("         Transaction Details" +
                "\n" + name_name + "\n" + "Your 24hours" + " " + travel + " " + "travelling insurance policy From:" + " " +
                FROM + " " + "To:" + " " + TO + " " + "is been processing" + "\n" + "please accept payment of" + " " + amot + " " + "by putting in your OTP number");

        accept.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (edit.getEditText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Enter OTP Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edit.getEditText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Wrong OTP Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                OTP = edit.getEditText().getText().toString();

                final Random random = new Random();
                Num = (String.valueOf(random.nextInt(5000)));

                if (checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Please Take Permission SMS and LOCATION in your Phone Settings", Toast.LENGTH_SHORT).show();
                    return;
                }
                SendMail();
                sendsms();
                move();
            }
        });
    }
    private void sh() {
        sp = getSharedPreferences("Key", MODE_PRIVATE);
        editor = sp.edit();
        editor.putString("Num", Num);
        editor.apply();
    }

    private void SendMail() {
        BackgroundMail.newBuilder(MainActivity3.this)
                .withUsername("sholankedapo@gmail.com")
                .withPassword("dapo07@sholanke")
                .withMailto(email_email)
                .withSubject("PolicyNotification")
                .withBody(name_name + " " + "You have 24hours" + " " + travel + " " + "Travelling Insurance Policy with us at Universal Insurance Plc." +
                        "\n" + "Travelling Details From:" + " " + FROM + " " + "To:" + " " + TO + " \n " + "Policy No: UIC/HRO/TRA/" + Num + "/02/21")
                .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "Mail Sent", Toast.LENGTH_LONG).show();
                    }
                })
                .withOnFailCallback(new BackgroundMail.OnFailCallback() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(), "Mail Failed", Toast.LENGTH_LONG).show();
                    }
                })
                .send();

    }

    private void sendsms() {
        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

        Toast.makeText(getApplicationContext(), phone_phone.toString(), Toast.LENGTH_LONG).show();
//Get the SmsManager instance and call the sendTextMessage method to send message
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("234" + phone_phone, null, "PolicyNotification:" + " " + name_name + " " + "You have 24hours" + " " + travel + " " + "Travelling Insurance Policy with us at Universal Insurance Plc." +
                        "\n" + "Travelling Detail From:" + " " + FROM + " " + "To:" + " " + TO + "\n " + "Policy No: UIC/HRO/TRA/" + Num + "/02/21"
                , pi, null);
        Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_SHORT).show();
    }
    private void move(){
        progressDialog = new ProgressDialog(MainActivity3.this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Processing Transaction");
        progressDialog.show();
       // progressDialog.setCancelable(false);

        Intent mydoc = new Intent(MainActivity3.this, MainActivity4.class);
        mydoc.putExtra("Name", name_name + "\n" +"You have 24hours" + " " + travel + " " + "travelling Insurance Policy with us at Universal Insurance Plc." +
                "\n" + "Travelling Details From:" + " " + FROM + " " + "To:" + " " + TO + " \n" + "Policy No: UIC/HRO/TRA/" + Num + "/02/21");
        startActivity(mydoc);
    }
}