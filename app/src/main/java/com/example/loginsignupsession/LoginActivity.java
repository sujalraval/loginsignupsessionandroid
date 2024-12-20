package com.example.loginsignupsession;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailLogin, etPasswordLogin;
    Button btnLogin;
    TextView tvSignup;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        etEmailLogin = findViewById(R.id.etEmail);
        etPasswordLogin = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);

        btnLogin.setOnClickListener(v -> {
            String email = etEmailLogin.getText().toString();
            String password = etPasswordLogin.getText().toString();

            // Retrieve stored credentials from session
            String storedEmail = sessionManager.getUserEmail();
            String storedPassword = sessionManager.getUserPassword();

            // Simulate user validation
            if (email.equals(storedEmail) && password.equals(storedPassword)) {
                sessionManager.createLoginSession(email, password);  // Already logged in, just update session
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        tvSignup.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SignupActivity.class)));
    }
}
