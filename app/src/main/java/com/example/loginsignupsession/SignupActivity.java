package com.example.loginsignupsession;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText etEmailSignup, etPasswordSignup, etConfirmPasswordSignup;
    Button btnSignup;
    TextView tvLogin;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmailSignup = findViewById(R.id.etEmailSignup);
        etPasswordSignup = findViewById(R.id.etPasswordSignup);
        etConfirmPasswordSignup = findViewById(R.id.etConfirmPasswordSignup);
        btnSignup = findViewById(R.id.btnSignup);
        tvLogin = findViewById(R.id.tvLogin);

        sessionManager = new SessionManager(this);

        btnSignup.setOnClickListener(v -> {
            String email = etEmailSignup.getText().toString();
            String password = etPasswordSignup.getText().toString();
            String confirmPassword = etConfirmPasswordSignup.getText().toString();

            if (password.equals(confirmPassword)) {
                // Store credentials in session manager
                sessionManager.createLoginSession(email, password);

                Toast.makeText(SignupActivity.this, "Signup Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(SignupActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            }
        });

        tvLogin.setOnClickListener(v -> startActivity(new Intent(SignupActivity.this, LoginActivity.class)));
    }
}
