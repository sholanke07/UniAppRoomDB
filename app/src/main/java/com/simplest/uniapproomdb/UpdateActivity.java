package com.simplest.uniapproomdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpdateActivity extends AppCompatActivity implements Handler.Callback {
    TextInputLayout name, address, phone, email, backdigit, amount, to, from, agentcode, reg, color, model, lastdigit, year, pin;
    TextInputLayout nextname, nextphone, nextmail, uploadpic;
    RadioGroup sex, policy, groupagent;
    RadioButton male, female, land, air, sea, agent, customer;
    String name_name, address_address, phone_phone, email_email, reg_reg, color_color, model_model;
    String TO, FROM, AGENT_CODE, card_lastdigit, PIN_PIN, YEAR_YEAR, back_backdigit, SEX, travel;
    String next_name, next_phone, next_mail, UploadPic, amount_amount, price, add = " ";
    int isClick = -1, istype = -1, onCheck = -1;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    LocationService LocationService;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    String LocationAddress;
    Handler handler;
    private Button Update;
    ImageView view, btnupload;
    private List<Client> clientList;
   // String Num_Num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        handler = new Handler(UpdateActivity.this);
        name = (TextInputLayout) findViewById(R.id.name);
        address = (TextInputLayout) findViewById(R.id.address);
        phone = (TextInputLayout) findViewById(R.id.number);
        email = (TextInputLayout) findViewById(R.id.email);
        nextmail = (TextInputLayout) findViewById(R.id.nextemail);
        nextphone = (TextInputLayout) findViewById(R.id.nextphone);
        nextname = (TextInputLayout) findViewById(R.id.nextkin);
        lastdigit = (TextInputLayout) findViewById(R.id.digit);
        year = (TextInputLayout) findViewById(R.id.expiry);
        pin = (TextInputLayout) findViewById(R.id.pin);
        backdigit = (TextInputLayout) findViewById(R.id.backdigit);
        agentcode = (TextInputLayout) findViewById(R.id.agentcode);
        amount = (TextInputLayout) findViewById(R.id.amount);
        from = (TextInputLayout) findViewById(R.id.from);
        to = (TextInputLayout) findViewById(R.id.to);
        reg = (TextInputLayout) findViewById(R.id.reg);
        model = (TextInputLayout) findViewById(R.id.model);
        color = (TextInputLayout) findViewById(R.id.color);
        uploadpic = (TextInputLayout) findViewById(R.id.upload);
        sex = (RadioGroup) findViewById(R.id.radiosex);
        policy = (RadioGroup) findViewById(R.id.radiopolicy);
        groupagent = (RadioGroup) findViewById(R.id.groupagent);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        agent = (RadioButton) findViewById(R.id.agent);
        customer = (RadioButton) findViewById(R.id.customer);
        land = (RadioButton) findViewById(R.id.land);
        air = (RadioButton) findViewById(R.id.air);
        sea = (RadioButton) findViewById(R.id.sea);
        btnupload = (ImageView) findViewById(R.id.btnupload);
        view = (ImageView) findViewById(R.id.view);
        Update = (Button) findViewById(R.id.update);
       // Delete = (Button) findViewById(R.id.delete);

        LocationService = new LocationService(
                UpdateActivity.this);

        final Client client = (Client) getIntent().getSerializableExtra("client");

        loadPolicy(client);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePolicy(client);
                sh();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = LocationService.getLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
                    builder.setTitle("Location Services Not Active");
                    builder.setMessage("Please enable Location Services and GPS");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Show location settings when the user acknowledges the alert dialog
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        }
                    });
                    Dialog alertDialog = builder.create();
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.show();

                }
            }
        });
        agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = " ";
                price = "80.00";
                amount.getEditText().setText(price);
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = " ";
                price = "100.00";
                amount.getEditText().setText(price);
            }
        });
        land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                travel = " ";
                travel = "Land";
            }
        });
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                travel = " ";
                travel = "Sea";
            }
        });
        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                travel = " ";
                travel = "Air";
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SEX = " ";
                SEX = "Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SEX = " ";
                SEX = "Female";
            }
        });
        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();

            }
        });
       // Delete.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
              /*  AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
                builder.setTitle("Are you sure you want to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //deleteTask(client);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                AlertDialog ad = builder.create();
                ad.show();*/
          //  }
       // });
    }

    private void sh() {
        sp = getSharedPreferences("Key", MODE_PRIVATE);
        editor = sp.edit();
        editor.putString("username", name_name);
        editor.putString("address", address_address);
        editor.putString("phone", phone_phone);
        editor.putString("model", model_model);
        editor.putString("color", color_color);
        editor.putString("Number", reg_reg);
        editor.putString("from", FROM);
        editor.putString("to", TO);
        editor.putString("email", email_email);
        editor.putString("Price", price);
        editor.putString("travel", travel);
       // editor.putString("Number", Num_Num);
        editor.apply();
    }

    private void upload() {
        int SELECT_PICTURE = 200;
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 200) {
            imageUri = data.getData();
            uploadpic.getEditText().setText(imageUri.toString());
        }
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        return false;
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {

            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    LocationAddress = bundle.getString("address");
                    break;
                default:
                    LocationAddress = null;
            }
            add = " ";
            add = LocationAddress;
            from.getEditText().setText(add);
        }
    }

    private void loadPolicy(Client client) {
        name.getEditText().setText(client.getName());
        address.getEditText().setText(client.getAddress());
        email.getEditText().setText(client.getEmail());
        phone.getEditText().setText(client.getPhone());
       // male.setText(client.getSex());
       // female.setText(client.getSex());
        nextname.getEditText().setText(client.getNextName());
        nextmail.getEditText().setText(client.getNextMail());
        nextphone.getEditText().setText(client.getNextPhone());
        //policy.getEditText().setText(client.getEmail());
        agentcode.getEditText().setText(client.getCode());
        from.getEditText().setText(client.getFrom());
        to.getEditText().setText(client.getTo());
        model.getEditText().setText(client.getModel());
        color.getEditText().setText(client.getColor());
        reg.getEditText().setText(client.getReg());
        uploadpic.getEditText().setText(client.getUploadpic());
        agentcode.getEditText().setText(client.getCode());
        backdigit.getEditText().setText(client.getBackCode());
        pin.getEditText().setText(client.getCardPin());
        year.getEditText().setText(client.getCardDate());
        lastdigit.getEditText().setText(client.getLast4());
        amount.getEditText().setText(client.getAmount());
        // travel.setChecked(client.getUploadpic());

    }
    private void updatePolicy(final Client client) {
        if ((name.getEditText().length() <= 0) || address.getEditText().length() <= 0 || phone.getEditText().length() <= 0 || year.getEditText().length() <= 0 || pin.getEditText().length() <= 0 || lastdigit.getEditText().length() <= 0 || backdigit.getEditText().length() <= 0 || nextname.getEditText().length() <= 0 || nextphone.getEditText().length() <= 0 || nextmail.getEditText().length() <= 0) {
            Toast.makeText(getApplicationContext(), "Please Input Your Details", Toast.LENGTH_SHORT).show();
            return;
        }
        //if (phone.length() <= 10){
        //Toast.makeText(getApplicationContext(), "Wrong Phone Number", Toast.LENGTH_SHORT).show();
        //return;
        // }

        if (pin.getEditText().length() <= 0) {
            Toast.makeText(getApplicationContext(), "Wrong Pin", Toast.LENGTH_SHORT).show();
            return;
        }
        if (year.getEditText().length() <= 0) {
            Toast.makeText(getApplicationContext(), "Wrong Year", Toast.LENGTH_SHORT).show();
            return;
        }
        if (lastdigit.getEditText().length() <= 0) {
            Toast.makeText(getApplicationContext(), "Please Enter Your card details", Toast.LENGTH_SHORT).show();
            return;
        }
        if (uploadpic.getEditText().length() <= 0) {
            Toast.makeText(getApplicationContext(), "Please Upload Your Picture", Toast.LENGTH_SHORT).show();
            return;
        }
        name_name = name.getEditText().getText().toString();
        address_address = address.getEditText().getText().toString();
        email_email = email.getEditText().getText().toString();
        phone_phone = phone.getEditText().getText().toString();
        card_lastdigit = lastdigit.getEditText().getText().toString();
        back_backdigit = backdigit.getEditText().getText().toString();
        AGENT_CODE = agentcode.getEditText().getText().toString();
        YEAR_YEAR = year.getEditText().getText().toString();
        PIN_PIN = pin.getEditText().getText().toString();
        reg_reg = reg.getEditText().getText().toString();
        color_color = color.getEditText().getText().toString();
        model_model = model.getEditText().getText().toString();
        FROM = from.getEditText().getText().toString();
        TO = to.getEditText().getText().toString();
        next_mail = nextmail.getEditText().getText().toString();
        next_phone = nextphone.getEditText().getText().toString();
        next_name = nextname.getEditText().getText().toString();
        UploadPic = uploadpic.getEditText().getText().toString();
        amount_amount = amount.getEditText().getText().toString();

        if (email_email.contains("@yahoo.com")) {

        } else if (email_email.contains("@gmail.com")) {

        } else if (email_email.contains("@YAHOO.COM")) {

        } else if (email_email.contains("@GMAIL.COM")) {

        } else if (next_mail.contains("@yahoo.com")) {

        } else if (next_mail.contains("@gmail.com")) {

        } else if (next_mail.contains("@YAHOO.COM")) {

        } else if (next_mail.contains("@GMAIL.COM")) {

        } else {
            Toast.makeText(getApplicationContext(), "Wrong Mail", Toast.LENGTH_SHORT).show();
            return;
        }
        isClick = sex.getCheckedRadioButtonId();
        if (isClick == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Sex", Toast.LENGTH_SHORT).show();
            return;
        }
        istype = policy.getCheckedRadioButtonId();
        if (istype == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Policy Type", Toast.LENGTH_SHORT).show();
            return;
        }
        onCheck = groupagent.getCheckedRadioButtonId();
        if (onCheck == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Agent or Customer", Toast.LENGTH_SHORT).show();
            return;
        }
        if (R.id.agent == onCheck) {
            if (agentcode.getEditText().length() <= 0) {
                Toast.makeText(getApplicationContext(), "Please Enter Agent Code", Toast.LENGTH_SHORT).show();
                return;
            }
           // final Random random = new Random();
            //Num_Num = (String.valueOf(random.nextInt(5000)));
        }
        // private void UpdatePolicy(final Client client) {
        class UpdateTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                client.setName(name_name);
                client.setAddress(address_address);
                client.setPhone(phone_phone);
                client.setEmail(email_email);
                client.setReg(reg_reg);
                client.setColor(color_color);
                client.setModel(model_model);
                client.setTo(TO);
                client.setFrom(FROM);
                client.setCode(AGENT_CODE);
                client.setSex(SEX);
                client.setTravel(travel);
                client.setNextName(next_name);
                client.setNextPhone(next_phone);
                client.setNextMail(next_mail);
                client.setUploadpic(UploadPic);
                client.setBackCode(back_backdigit);
                client.setCardDate(YEAR_YEAR);
                client.setCardPin(PIN_PIN);
                client.setLast4(card_lastdigit);
                client.setAmount(amount_amount);
               // client.setNUMBER(Num_Num);

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
                startActivity(new Intent(UpdateActivity.this, MainActivity3.class));
            }
        }
        UpdateTask ut = new UpdateTask();
        ut.execute();
    }
}


       // public void deleteTask(final Client client) {
           /* class DeleteTask extends AsyncTask<Void, Void, Void> {

                @Override
                protected Void doInBackground(Void... voids) {
                    DatabaseClient.getInstance(getApplicationContext())
                            .getAppDataBase()
                            .Dao()
                            .delete(client);
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(UpdateActivity.this, MainActivity5.class));
                }
            }

            DeleteTask dt = new DeleteTask();
            dt.execute();

        }*/














