package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q7Activity extends AppCompatActivity {
    Button buttonQ7;
    RadioButton radioButton1Q7, radioButton2Q7, radioButton3Q7, radioButton4Q7, radioButton5Q7;
    TextView textViewNome;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q7);

        buttonQ7 = findViewById(R.id.buttonQ7);
        radioButton1Q7 = findViewById(R.id.radioButton1Q7);
        radioButton2Q7 = findViewById(R.id.radioButton2Q7);
        radioButton3Q7 = findViewById(R.id.radioButton3Q7);
        radioButton4Q7 = findViewById(R.id.radioButton4Q7);
        radioButton5Q7 = findViewById(R.id.radioButton5Q7);
        textViewNome = findViewById(R.id.editTextNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        erro = bundle.getInt("erro");

        if(!nome.equals(""))
            textViewNome.setText(nome);
        else
            textViewNome.setText("Anônimo");

        buttonQ7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton1Q7.isChecked()){
                    Toast.makeText(Q7Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q7Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q7Activity.this, Q8Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
