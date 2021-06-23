package com.simplest.uniapproomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;
import com.google.android.material.textfield.TextInputLayout;

public class ClaimActivity extends AppCompatActivity {
    TextInputLayout policyname, policyNo, date, details, picture, medical, death, original, claimEmail;
    Button submit;
    ImageView pic, med, del, org;
    String policy_name, policy_No, date_date, details_details, medical_medical, death_death, original_original,
            picture_picture, claim_email;
    Uri imageUri;
    ProgressDialog progressDialog;
    private static final int SELECT_PICTURE = 200;
    private static final int SELECT_PICTURE2 = 300;
    private static final int SELECT_PICTURE3 = 400;
    private static final int SELECT_PICTURE4 = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim);
        policyname = (TextInputLayout) findViewById(R.id.policyname);
        policyNo = (TextInputLayout) findViewById(R.id.policyNo);
        date = (TextInputLayout) findViewById(R.id.occurrence);
        details = (TextInputLayout) findViewById(R.id.details);
        picture = (TextInputLayout) findViewById(R.id.picture);
        medical = (TextInputLayout) findViewById(R.id.medical);
        death = (TextInputLayout) findViewById(R.id.death);
        original = (TextInputLayout) findViewById(R.id.original);
        claimEmail = (TextInputLayout) findViewById(R.id.email);
        submit = (Button) findViewById(R.id.btn);
        pic = (ImageView) findViewById(R.id.pic);
        med = (ImageView) findViewById(R.id.med);
        del = (ImageView) findViewById(R.id.dea);
        org = (ImageView) findViewById(R.id.org);

        final Client client = (Client) getIntent().getSerializableExtra("client");

        //loadPolicy(client);


        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image(SELECT_PICTURE);
            }
        });
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image(SELECT_PICTURE2);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image(SELECT_PICTURE3);
            }
        });
        org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image(SELECT_PICTURE4);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updatetask(client);
                //image();
                submit();
                SendMail();
            }
        });
    }

   // private void loadPolicy(Client client) {
       // policyNo.getEditText().setText(client.getPolicyNo());
    //}

    public void image(int req_code) {

        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), req_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            imageUri = data.getData();
            if (requestCode == SELECT_PICTURE)
            {
                picture.getEditText().setText(imageUri.toString());
               // selectedPath1 = getPath(selectedImageUri);
               // System.out.println("selectedPath1 : " + selectedPath1);
            }
            if (requestCode == SELECT_PICTURE2)
            {
                medical.getEditText().setText(imageUri.toString());
               // selectedPath2 = getPath(selectedImageUri);
               // System.out.println("selectedPath2 : " + selectedPath2);
            }
            if (requestCode == SELECT_PICTURE3)
            {
                death.getEditText().setText(imageUri.toString());
                // selectedPath2 = getPath(selectedImageUri);
                // System.out.println("selectedPath2 : " + selectedPath2);
            }
            if (requestCode == SELECT_PICTURE4)
            {
                original.getEditText().setText(imageUri.toString());
                // selectedPath2 = getPath(selectedImageUri);
                // System.out.println("selectedPath2 : " + selectedPath2);
            }
           // tv.setText("Selected File paths : " + selectedPath1 + "," + selectedPath2);
        }
    }

    private void SendMail() {
        BackgroundMail.newBuilder(ClaimActivity.this)
                .withUsername("sholankedapo@gmail.com")
                .withPassword("dapo07@sholanke")
                .withMailto(claim_email)
                .withMailto("adekoyagbolabo@gmail.com")
                //.withAttachments(picture_picture)
                .withSubject("Claim Request")
                /*.withBody("Details of Claim Incident" + "\n" + "Policy Type:" + " " + policy_name + "\n" + "Policy No: UIC/HRO/TRA/ 556 /02/21" + "\n" + "Date of Occurrence:" + " " + date_date + "\n" +
                        "Details of incident:" + " " + details_details + "\n" + "Attachment of claim document" + "\n" + picture_picture + "\n" + medical_medical + "\n" + death_death + "\n" + original_original + "\n" +
                        "Your 24hours travelling insurance claim request has been sent and is been processed. We will get back to you within the next 24hours." + "\n" + "Thank you for choosing Universal Insurance Plc ")*/
                 .withBody("Your 24hours travelling insurance claim request with Policy No:" + " " + policy_No + " " + "has been sent and is been processed. We will get back to you within the next 24hours." + "\n" + "Thank you for choosing Universal Insurance Plc ")
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
        Intent intent = new Intent(ClaimActivity.this, MainActivity2.class);
        startActivity(intent);

    }

   /* private void updatetask(final Client client) {
        class UpdateTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                client.setPolicyNo(policy_No);

                DatabaseClient.getInstance(getApplicationContext())
                        .getAppDataBase()
                        .Dao()
                        .update(client);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                finish();
                // startActivity(new Intent(UpdateActivity.this, MainActivity3.class));
            }
        }
        UpdateTask ut = new UpdateTask();
        ut.execute();
    }*/

    private void submit() {
        policy_name = policyname.getEditText().getText().toString();
        policy_No = policyNo.getEditText().getText().toString();
        date_date = date.getEditText().getText().toString();
        details_details = details.getEditText().getText().toString();
        claim_email = claimEmail.getEditText().getText().toString();


        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                Client client = new Client();
                client.setPolicyName(policy_name);
                client.setPolicyNo(policy_No);
                client.setDate(date_date);
                client.setDetails(details_details);
                client.setPicture(picture_picture);
                client.setMedical(medical_medical);
                client.setOriginal(original_original);
                client.setDeath(death_death);
                client.setClaimEmail(claim_email);


                //Adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDataBase()
                        .Dao()
                        .insert(client);
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
                // Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                //startActivity(intent);
            }
        }
        SaveTask st = new SaveTask();
        st.execute();
   }

}


