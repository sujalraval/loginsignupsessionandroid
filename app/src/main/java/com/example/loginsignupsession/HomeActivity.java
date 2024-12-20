package com.example.loginsignupsession;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView tvWelcome, tvUserEmail;
    Button btnLogout;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sessionManager = new SessionManager(this);

        // Initialize views
        tvWelcome = findViewById(R.id.tvWelcome);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        btnLogout = findViewById(R.id.btnLogout);

        // Check if the user is logged in, otherwise redirect to login
        if (!sessionManager.isLoggedIn()) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        }

        // Display the logged-in user's email
        tvUserEmail.setText(sessionManager.getUserEmail());

        // Set a welcome message
        tvWelcome.setText("Welcome, " + sessionManager.getUserEmail());

        // Handle logout functionality
        btnLogout.setOnClickListener(v -> {
            sessionManager.logout();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        });
    }
}
