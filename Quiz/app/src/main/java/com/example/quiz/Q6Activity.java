package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q6Activity extends AppCompatActivity {

    Button buttonQ6;
    RadioButton radioButton1Q6, radioButton2Q6, radioButton3Q6, radioButton4Q6, radioButton5Q6;
    TextView textViewNome;
    int joinha;
    int erro;
    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q6);

        buttonQ6 = findViewById(R.id.buttonQ6);
        radioButton1Q6 = findViewById(R.id.radioButton1Q6);
        radioButton2Q6 = findViewById(R.id.radioButton2Q6);
        radioButton3Q6 = findViewById(R.id.radioButton3Q6);
        radioButton4Q6 = findViewById(R.id.radioButton4Q6);
        radioButton5Q6 = findViewById(R.id.radioButton5Q6);
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

        buttonQ6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton5Q6.isChecked()){
                    Toast.makeText(Q6Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q6Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q6Activity.this, Q7Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
