package com.example.implicitintent;


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
    Intent intent,chooser=null;
    public void process(View v)
    {
        if (v.getId()==R.id.LaunchMap)
        {
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:10.065206,76.629128"));
            chooser=intent.createChooser(intent,"Launch Maps");
            startActivity(chooser);
        }
        if (v.getId()==R.id.GPlay)
        {
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.kiloo.subwaysurf"));
            chooser=intent.createChooser(intent,"Google Play");
            startActivity(chooser);
        }
        if (v.getId()==R.id.Email) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto"));
            String to[] = {"thasnikichu101@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "From Emulator");
            intent.putExtra(Intent.EXTRA_TEXT, "My First Mail");
            intent.setType("message/rfc822");
            chooser = intent.createChooser(intent, "Gmail Application");
            startActivity(chooser);
        }
        if (v.getId()==R.id.Messenger) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("android.resource://com.example.implicitintent/drawable/+R.drawable.flower.jpg"));
            intent.putExtra(Intent.EXTRA_STREAM, "imgUri");
            intent.putExtra(Intent.EXTRA_SUBJECT, "From Emulator");
            intent.putExtra(Intent.EXTRA_TEXT, "I have attached an attachment");
            intent.setType("image/*");
            chooser = intent.createChooser(intent, "Messenger");
            startActivity(chooser);
        }
    }
}
