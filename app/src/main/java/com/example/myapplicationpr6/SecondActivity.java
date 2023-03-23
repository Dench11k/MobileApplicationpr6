package com.example.myapplicationpr6;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    TextView textView;
    ActivityResultLauncher<Intent> activityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.zanchok);
        textView = (TextView) findViewById(R.id.textView9);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);
        TextView textView = new TextView(this);
        textView = (TextView) findViewById(R.id.textView10);
        Intent intent1 = getIntent();
        String name1 = intent.getStringExtra("name1");
        textView.setText(name1);
        TextView textView1 = new TextView(this);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        Log.i(TAG, "ButtonOn_1");
                        Toast.makeText(SecondActivity.this, "Переход осуществлен", Toast.LENGTH_SHORT).show();
                        TextView nameText = findViewById(R.id.textView9);
                        TextView nameText1 = findViewById(R.id.textView10);
                        String name = nameText.getText().toString();
                        String name1 = nameText1.getText().toString();
                        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("name1", name1);
                        activityLauncher.launch(intent);
                    }
                }
        );
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            TextView info = findViewById(R.id.textView20);
                            String car = data.getStringExtra("namecar");
                            info.setText(car);
                        }
                    }
                });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}