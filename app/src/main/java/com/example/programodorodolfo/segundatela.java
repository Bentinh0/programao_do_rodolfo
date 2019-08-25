package com.example.programodorodolfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class segundatela extends AppCompatActivity {

    Intent intent;
    Bundle pacote = new Bundle();

    public void fazerToast(String texto){
        Toast.makeText(getApplicationContext(),
                texto,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela);

        intent = new Intent(this, terceiratela.class);

        ListView listViewDaTela = findViewById(R.id.listinha);

        listViewDaTela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fazerToast("Calculando...");
                pacote.putString("relacionamento",((TextView)view).getText().toString());
                intent.putExtras(pacote);
                startActivity(intent);
            }

        });

    }

}
