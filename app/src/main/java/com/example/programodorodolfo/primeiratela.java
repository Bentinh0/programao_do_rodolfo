package com.example.programodorodolfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class primeiratela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiratela);


    }

    public void mudaratela (View view){
        Intent intent = new Intent(this, segundatela.class);
        startActivity(intent);
    }



}
