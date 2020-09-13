package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q10Activity extends AppCompatActivity {

    Button buttonQ10;
    RadioButton radioButton1Q10, radioButton2Q10, radioButton3Q10, radioButton4Q10, radioButton5Q10;
    TextView textViewNome;
    String nome;
    int joinha;
    int erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q10);

        buttonQ10 = findViewById(R.id.buttonQ10);
        radioButton1Q10 = findViewById(R.id.radioButton1Q10);
        radioButton2Q10 = findViewById(R.id.radioButton2Q10);
        radioButton3Q10 = findViewById(R.id.radioButton3Q10);
        radioButton4Q10 = findViewById(R.id.radioButton4Q10);
        radioButton5Q10 = findViewById(R.id.radioButton5Q10);
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

        buttonQ10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton4Q10.isChecked()){
                    Toast.makeText(Q10Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    joinha++;
                }
                else{
                    Toast.makeText(Q10Activity.this, "Incorreto", Toast.LENGTH_SHORT).show();
                    erro++;
                }
                Intent intent = new Intent(Q10Activity.this, FimActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("joinha", joinha);
                intent.putExtra("erro", erro);
                AlertDialog.Builder msg = new AlertDialog.Builder(Q10Activity.this);
                startActivity(intent);
            }
        });
    }
}
