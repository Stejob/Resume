package com.example.myresume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMe(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.phone_number)));
        startActivity(intent);
    }

    public void emailMe(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { getResources().getString(R.string.email)});
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.email_response_subject));
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.email_response_body));
        startActivity(Intent.createChooser(intent, ""));
    }

    public void locateMe(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.location_on_map)));
        startActivity(intent);
    }


}