package com.example.loginsignupsession;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> {
            // Navigate to LoginActivity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish(); // Finish MainActivity to prevent going back to it
        });
    }
}
