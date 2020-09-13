package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Q3Activity extends AppCompatActivity {
    Button buttonQ3;
    CheckBox checkBoxQ3, checkBox2Q3, checkBox3Q3, checkBox4Q3, checkBox5Q3;
    TextView textViewNome;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);

        buttonQ3 = findViewById(R.id.buttonQ3);
        checkBoxQ3 = findViewById(R.id.checkBoxQ3);
        checkBox2Q3 = findViewById(R.id.checkBox2Q3);
        checkBox3Q3 = findViewById(R.id.checkBox3Q3);
        checkBox4Q3 = findViewById(R.id.checkBox4Q3);
        checkBox5Q3 = findViewById(R.id.checkBox5Q3);
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

        buttonQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox2Q3.isChecked() && checkBox3Q3.isChecked() && !checkBox4Q3.isChecked() && !checkBox5Q3.isChecked() && !checkBoxQ3.isChecked()){
                    Toast.makeText(Q3Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q3Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q3Activity.this, Q4Activity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                startActivity(intent);
            }
        });
    }
}
