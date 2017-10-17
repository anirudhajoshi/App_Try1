package com.example.aniru.publibapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOk(View v) {
        Toast.makeText(this, "OnOk", Toast.LENGTH_SHORT).show();
    }

    public void OnCamera(View v) {
        Toast.makeText(this, "OnCamera", Toast.LENGTH_SHORT).show();
    }

    public void OnArchive(View v) {
        Toast.makeText(this, "OnArchive", Toast.LENGTH_SHORT).show();
    }

    public void OnFavorites(View v) {
        Toast.makeText(this, "OnFavs", Toast.LENGTH_SHORT).show();
    }

}
