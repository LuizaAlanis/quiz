package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q1Activity extends AppCompatActivity {
    Button buttonQ1;
    RadioButton radioButton1Q1, radioButton2Q1, radioButton3Q1, radioButton4Q1, radioButton5Q1;
    TextView textViewNome;
    String nome = "";
    int joinha = 0;
    int erro = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        buttonQ1 = findViewById(R.id.buttonQ1);
        radioButton1Q1 = findViewById(R.id.radioButton1Q1);
        radioButton2Q1 = findViewById(R.id.radioButton2Q1);
        radioButton3Q1 = findViewById(R.id.radioButton3Q1);
        radioButton4Q1 = findViewById(R.id.radioButton4Q1);
        radioButton5Q1 = findViewById(R.id.radioButton5Q1);
        textViewNome = findViewById(R.id.editTextNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        joinha = bundle.getInt("joinha");
        erro = bundle.getInt("erros");

        if(!nome.equals(""))
            textViewNome.setText(nome);
        else
            textViewNome.setText("Anônimo");

        buttonQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton2Q1.isChecked()){
                    Toast.makeText(Q1Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q1Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q1Activity.this, Q2Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
