package com.simplest.uniapproomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutUs extends AppCompatActivity {
    TextView aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        aboutus = (TextView)findViewById(R.id.aboutus);


        aboutus.setText("The Universal Insurance Plc" + "\n" + "Is one of the nation’s largest personal lines insurer" + "\n" + " With over N8 billion in assets, we sell eight major lines of insurance, including auto, property and commercial" + "\n" + " We are widely known for providing peace of mind to our clients and enriching their quality of life through our partnership in the management of the risks they face" + "\n" +
                "Contact Us: info@universalinsuranceplc.com +234(1)2934645 +234(0)8037589255" + "\n" +
                "Head Office Address: 8, Gbagada Expressway, Anthony, Lagos, Nigeria" + "\n" +
                "E-mail:info@universalinsuranceplc.com");
    }
}