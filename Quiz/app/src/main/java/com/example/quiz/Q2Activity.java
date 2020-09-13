package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q2Activity extends AppCompatActivity {
    Button buttonQ2;
    RadioButton radioButton1Q2, radioButton2Q2, radioButton3Q2, radioButton4Q2, radioButton5Q2;
    TextView textViewNome;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);

        buttonQ2 = findViewById(R.id.buttonQ2);
        radioButton1Q2 = findViewById(R.id.radioButton1Q2);
        radioButton2Q2 = findViewById(R.id.radioButton2Q2);
        radioButton3Q2 = findViewById(R.id.radioButton3Q2);
        radioButton4Q2 = findViewById(R.id.radioButton4Q2);
        radioButton5Q2 = findViewById(R.id.radioButton5Q2);
        textViewNome = findViewById(R.id.editTextNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        joinha = bundle.getInt("joinha");
        erro = bundle.getInt("erro");

        if(!nome.equals(""))
            textViewNome.setText(nome);
        else
            textViewNome.setText("Anônimo");

        buttonQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton5Q2.isChecked()){
                    Toast.makeText(Q2Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q2Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q2Activity.this, Q3Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
