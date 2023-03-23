package com.example.myapplicationpr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

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
    private static final String TAG = "MyApp";
    public void onMyButton1(View view){
        Toast.makeText(this,"Возврат осуществлен",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"ButtonOn");
        Intent intent = new Intent();
        EditText nameText = findViewById(R.id.editTextCar);
        String name = nameText.getText().toString();
        intent.putExtra("namecar", name);
        setResult(RESULT_OK,intent);
        finish();

    }
}