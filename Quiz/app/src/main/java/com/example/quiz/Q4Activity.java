package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Q4Activity extends AppCompatActivity {
    Button buttonQ4;
    CheckBox checkBoxQ4, checkBox2Q4, checkBox3Q4, checkBox4Q4, checkBox5Q4;
    TextView textViewNome;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);

        buttonQ4 = findViewById(R.id.buttonQ4);
        checkBoxQ4 = findViewById(R.id.checkBoxQ4);
        checkBox2Q4 = findViewById(R.id.checkBox2Q4);
        checkBox3Q4 = findViewById(R.id.checkBox3Q4);
        checkBox4Q4 = findViewById(R.id.checkBox4Q4);
        checkBox5Q4 = findViewById(R.id.checkBox5Q4);
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

        buttonQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkBoxQ4.isChecked() && !checkBox3Q4.isChecked() && !checkBox5Q4.isChecked() && checkBox2Q4.isChecked() && checkBox4Q4.isChecked()){
                    Toast.makeText(Q4Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q4Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q4Activity.this, Q5Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
