package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button buttonStart;
    EditText editTextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonStart = findViewById(R.id.buttonStart);
        editTextNome = findViewById(R.id.editTextNome);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNome.getText().toString()!=""){
                    Toast.makeText(LoginActivity.this, "Correto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Q1Activity.class);
                    intent.putExtra("nome", editTextNome.getText().toString());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Correto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
