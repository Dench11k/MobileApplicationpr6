package com.example.myapplicationpr6;

import static com.example.myapplicationpr6.R.drawable._fc08dc1_fd63_40cf_bdd3_9b39e6f70ae3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    // Идентификатор уведомления
    private static final int NOTIFY_ID = 101;

    // Идентификатор канала
    private static String CHANNEL_ID = "Car channel";
    public final static String name1 = "OK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView textView;
        textView = (TextView) findViewById(R.id.textView11);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);
        textView = new TextView(this);
        textView = (TextView) findViewById(R.id.textView17);
        Intent intent1 = getIntent();
        String name1 = intent.getStringExtra("name1");
        textView.setText(name1);
        TextView textView1 = new TextView(this);


    }
    public static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
    private void showNotification() {
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(ThirdActivity.this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(
                        R.string.text_name_5))
                .setContentText("Автомобиль успешно забронирован!")
                .setPriority(NotificationCompat.PRIORITY_LOW);
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, builder.build());
        }

    private static final String TAG = "MyApp";

    public void onMyButton1(View view) {

            Intent intent = new Intent();
            EditText nameText = findViewById(R.id.editTextCar);
            String name = nameText.getText().toString();
            intent.putExtra("namecar", name);
            setResult(RESULT_OK, intent);
            showNotification();
            finish();


    }




}