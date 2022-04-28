package com.example.week11_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

            // User may have declined earlier, ask Android if we should show him a reason
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CALENDAR}, 1907);
            } else {
                //Do the stuff that requires permission...
                Toast.makeText(this,"There is permission",Toast.LENGTH_LONG).show();
            }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1907: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, do your work....
                    Toast.makeText(this,"Permission is allowed.",Toast.LENGTH_LONG).show();
                } else {
                    // permission denied
                    // Disable the functionality that depends on this permission.
                    Toast.makeText(this,"Permission is denied.",Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' statements for other permssions
        }
    }
}