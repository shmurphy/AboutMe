package com.example.shmurphy.aboutme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MyActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayText(View view) {
        Intent intent = new Intent(this, DisplayTextActivity.class);
        startActivity(intent);
    }

    public void displayImage(View view) {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    public void webpage(View view) {
        Uri webpage = Uri.parse("http://developer.android.com/index.html");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void toast(View view) {  // TOAST
//        Toast.makeText(this, "YAY, TOAST!!!", Toast.LENGTH_LONG).show();
        makeToast("toast");
    }

    public void makeToast(String response) {
        if(response.equals("toast")) {
            Toast.makeText(this, "YAY, TOAST!!!", Toast.LENGTH_LONG).show();
        } else if (response.equals("yes")) {
            Toast.makeText(this, "Yeah, cats are awesome!", Toast.LENGTH_LONG).show();
        } else if (response.equals("no")) {
            Toast.makeText(this, "You don't like cats? What a shame.", Toast.LENGTH_LONG).show();
        }
    }

    public void alertDialog(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setPositiveButton(R.string.bien, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.i(TAG, "User hit positive");
                makeToast("yes");

            }
        }).setNegativeButton(R.string.no_bueno, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.i(TAG, "User hit negative");
                makeToast("no");
            }
        }).setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
