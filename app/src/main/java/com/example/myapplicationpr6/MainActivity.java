package com.example.myapplicationpr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";
    public void onMyButton(View view){
        Toast.makeText(this,"Вход выполнен",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"ButtonOn");
        EditText nameText = findViewById(R.id.editTextTextPersonName);
        EditText nameText1 = findViewById(R.id.editTextTextPersonName2);
        String name = nameText.getText().toString();
        String name1 = nameText1.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("name1",name1 );
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nameText = findViewById(R.id.textView2);
        String text = getResources().getString(R.string.text_name_5);
        nameText.setText(text);
        Toast.makeText(getApplicationContext(), "OnCreate", Toast.LENGTH_SHORT).show();
        Log.e(TAG,"onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "OnStart", Toast.LENGTH_SHORT).show();
        Log.w(TAG,"onStart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "OnStop", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "OnDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "OnPause", Toast.LENGTH_SHORT).show();
        Log.v(TAG,"onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "OnResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onResume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "OnRestart", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onRestart");
    }
}