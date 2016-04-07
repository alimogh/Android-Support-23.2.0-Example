package com.androidsupport2320example;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;
    private Random random = new Random();
    private TextView textView_201873_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //setContentView(R.layout.fab_sometimes_broken);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findViewById(R.id.button_set_wrapped).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FloatingActionButton)findViewById(R.id.fab)).setImageResource(R.drawable.ic_warning_wrapped);
            }
        });

        findViewById(R.id.button_set_wrapped).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FloatingActionButton)findViewById(R.id.fab)).setImageResource(R.drawable.ic_warning);
            }
        });
    }

    // region Nothing to see here...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Toast.makeText(this, "Ouch! That hurt!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    // endregion

    private void showNotification(@DrawableRes int drawableId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        Notification notification = builder
                .setAutoCancel(true)
                .setContentText("I'm a notification!")
                .setContentTitle("Support 23.2.0 Issues")
                .setSmallIcon(drawableId)
                .build();

        final int notificationId = 001;
        final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification);

    }
}
