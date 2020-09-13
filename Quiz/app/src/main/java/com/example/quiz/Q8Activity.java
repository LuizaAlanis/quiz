package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q8Activity extends AppCompatActivity {

    Button buttonQ8;
    RadioButton radioButton1Q8, radioButton2Q8, radioButton3Q8, radioButton4Q8, radioButton5Q8;
    TextView textViewNome;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q8);

        buttonQ8 = findViewById(R.id.buttonQ8);
        radioButton1Q8 = findViewById(R.id.radioButton1Q8);
        radioButton2Q8 = findViewById(R.id.radioButton2Q8);
        radioButton3Q8 = findViewById(R.id.radioButton3Q8);
        radioButton4Q8 = findViewById(R.id.radioButton4Q8);
        radioButton5Q8 = findViewById(R.id.radioButton5Q8);
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

        buttonQ8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton4Q8.isChecked()){
                    Toast.makeText(Q8Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q8Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q8Activity.this, Q9Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
