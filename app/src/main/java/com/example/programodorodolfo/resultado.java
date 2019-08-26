package com.example.programodorodolfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Bundle pacote = getIntent().getExtras();

        String relacionamentoEscolhido = pacote.getString("relacionamento");
        TextView relacionamento = (TextView) findViewById(R.id.viewRelacionamento);
        relacionamento.setText("Relacionamento: " + relacionamentoEscolhido);

        String signoEscolhido = pacote.getString("signo");
        TextView signo = (TextView) findViewById(R.id.viewSigno);
        signo.setText("Signo: " + signoEscolhido);

    }

    public void voltarParaaPrimeiraTela(View view) {
        Intent intent = new Intent(this, primeiratela.class);
        startActivity(intent);
    }
}