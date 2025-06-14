package com.example.alertdialogbox;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AlertDialog tcReadDialog = new AlertDialog.Builder(this).create();
        tcReadDialog.setTitle("Terms and Conditions");
        tcReadDialog.setMessage("Terms and conditions as mentioned here.");
        tcReadDialog.setIcon(R.drawable.baseline_info_24);
        tcReadDialog.setButton(Dialog.BUTTON_POSITIVE, "Yes, I've read.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Welcome, please proceed now!", Toast.LENGTH_SHORT).show();
            }
        });
        tcReadDialog.show();

        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(this);
        deleteDialog.setTitle("Delete");
        deleteDialog.setIcon(R.drawable.baseline_delete_forever_24);
        deleteDialog.setMessage("Are you sure want to delete?");
        deleteDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "File Deleted!", Toast.LENGTH_SHORT).show();
            }
        });
        deleteDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Files Not deletes!", Toast.LENGTH_SHORT).show();
            }
        });
        deleteDialog.show();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setTitle("Exit");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitDialog.setMessage("Are you sure want to Exit?");
        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });
        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Ok Stay In!", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancelled Request!", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();
    }
}