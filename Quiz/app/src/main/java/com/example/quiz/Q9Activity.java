package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q9Activity extends AppCompatActivity {

    Button buttonQ9;
    RadioButton radioButton1Q9, radioButton2Q9, radioButton3Q9, radioButton4Q9, radioButton5Q9;
    TextView textViewNome;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q9);

        buttonQ9 = findViewById(R.id.buttonQ9);
        radioButton1Q9 = findViewById(R.id.radioButton1Q9);
        radioButton2Q9 = findViewById(R.id.radioButton2Q9);
        radioButton3Q9 = findViewById(R.id.radioButton3Q9);
        radioButton4Q9 = findViewById(R.id.radioButton4Q9);
        radioButton5Q9 = findViewById(R.id.radioButton5Q9);
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

        buttonQ9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton1Q9.isChecked()){
                    Toast.makeText(Q9Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q9Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q9Activity.this, Q10Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
