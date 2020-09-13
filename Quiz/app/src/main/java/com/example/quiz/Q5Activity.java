package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q5Activity extends AppCompatActivity {
    Button buttonQ5;
    RadioButton radioButton1Q5, radioButton2Q5, radioButton3Q5, radioButton4Q5, radioButton5Q5;
    TextView textViewNome;
    int joinha;
    String nome;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);

        buttonQ5 = findViewById(R.id.buttonQ5);
        radioButton1Q5 = findViewById(R.id.radioButton1Q5);
        radioButton2Q5 = findViewById(R.id.radioButton2Q5);
        radioButton3Q5 = findViewById(R.id.radioButton3Q5);
        radioButton4Q5 = findViewById(R.id.radioButton4Q5);
        radioButton5Q5 = findViewById(R.id.radioButton5Q5);
        textViewNome = findViewById(R.id.editTextNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        joinha = bundle.getInt("joinha");

        if(!nome.equals(""))
            textViewNome.setText(nome);
        else
            textViewNome.setText("Anônimo");


        buttonQ5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton1Q5.isChecked()){
                    Toast.makeText(Q5Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q5Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q5Activity.this, Q6Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
