package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layoutMain;
    EditText editColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("TAG", "onCreate");

        layoutMain = findViewById(R.id.layout_main);
        editColor = findViewById(R.id.edit_color);

        editColor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String color = editable.toString();
                if (color.equals("red"))
                    layoutMain.setBackgroundColor(0xFFFF0000);
                else if (color.equals("green"))
                    layoutMain.setBackgroundColor(0xFF00FF00);
                else if (color.equals("blue"))
                    layoutMain.setBackgroundColor(0xFF0000FF);
                else
                    layoutMain.setBackgroundColor(0xFFFFFFFF);
            }
        });

        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.btn_move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("TAG", "onResume");
        SharedPreferences prefs = getSharedPreferences("COLOR", 0);
        String color = prefs.getString("BackgroundColor", "");
        editColor.setText(color);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("TAG", "onPause");

        String color = editColor.getText().toString();
        SharedPreferences prefs = getSharedPreferences("COLOR", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("BackgroundColor", color);
        editor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v("TAG", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("TAG", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
    }
}