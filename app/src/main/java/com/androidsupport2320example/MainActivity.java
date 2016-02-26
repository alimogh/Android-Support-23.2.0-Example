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

        setContentView(R.layout.fab_alway_broken);
        //setContentView(R.layout.fab_sometimes_broken);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomFloatingActionButtonBackgroundColor();
            }
        });

        textView_201873_color = (TextView) findViewById(R.id.textview_201873_color);

        setRandomFloatingActionButtonBackgroundColor();

        findViewById(R.id.button_show_notification_layer_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(R.drawable.ic_warning_wrapped);
            }
        });

        findViewById(R.id.button_show_notification_layer_list_with_srccompat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(R.drawable.ic_warning_wrapped_srccompat);
            }
        });

        findViewById(R.id.button_show_notification_png).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(R.drawable.icon);
            }
        });

        findViewById(R.id.button_show_notification_vector).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(R.drawable.ic_warning);
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

    private void setRandomFloatingActionButtonBackgroundColor() {
        final int randomColor = random.nextInt(4);

        int color;
        String colorString;

        switch (randomColor) {
            case 0:
                color = ContextCompat.getColor(MainActivity.this, R.color.amber_900);
                colorString = "AMBER";
                break;
            case 1:
                color = ContextCompat.getColor(MainActivity.this, R.color.light_green_A200);
                colorString = "GREEN";
                break;
            case 2:
                color = ContextCompat.getColor(MainActivity.this, R.color.brown_600);
                colorString = "BROWN";
                break;
            default:
                color = ContextCompat.getColor(MainActivity.this, R.color.blue_700);
                colorString = "BLUE";
                break;
        }

        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(color));

        textView_201873_color.setText(colorString);
        textView_201873_color.setTextColor(color);
    }

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
