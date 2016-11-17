package com.nyp.sit.dit.it2107.myshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    TextView welcomeTV;
    Button logoutBT;
    EditText quanET;
    final static String RETURN_MSG ="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        welcomeTV = (TextView)findViewById(R.id.welcomeTV);
        logoutBT = (Button)findViewById(R.id.LogoutBT);
        quanET = (EditText) findViewById(R.id.quanET);

        Bundle extras = this.getIntent().getExtras();
        String usernameFromMain = extras.getString("username");

        welcomeTV.setText("Welcome " + usernameFromMain);

        logoutBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent output = new Intent();
                output.putExtra(RETURN_MSG, "You have bought " + quanET.getText().toString() + " Android Phones");
                setResult(RESULT_OK, output);
                finish();
            }
        });
    }
}
