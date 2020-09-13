package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class FimActivity extends AppCompatActivity {
    Button buttonRestart;
    TextView textViewNome, textViewAcertos, textViewErros;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);

        buttonRestart = findViewById(R.id.buttonRestart);
        textViewAcertos = findViewById(R.id.textViewAcertos);
        textViewErros = findViewById(R.id.textViewErros);
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

        textViewAcertos.setText("Total de acertos: "+joinha);
        textViewErros.setText("Total de erros: "+erro);

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FimActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
