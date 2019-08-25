package com.example.programodorodolfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class terceiratela extends AppCompatActivity {

    Bundle pacote;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceiratela);

        pacote = getIntent().getExtras();
        intent = new Intent(this, resultado.class);
    }

    public void exibirAlertDialog (){
        AlertDialog.Builder builderAlert = new AlertDialog.Builder(this);
        builderAlert.setTitle("Confirmação");
        builderAlert.setMessage("Confirma o cadastro?");

        DialogInterface.OnClickListener botaoSim = new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which) {
                intent.putExtras(pacote);
                startActivity(intent);
            }
        };
        builderAlert.setPositiveButton( "Sim", botaoSim);
        builderAlert.create().show();
    }

    public void notificar(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("my_channel_id",
                            "my_channel",
                            NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"my_channel_id");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("RESULTADO");
        builder.setContentText("Resultado calculado!");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(123456, builder.build());
    }

    public void proximaTela(View view){
        String signo = ((Spinner)findViewById(R.id.signo)).getSelectedItem().toString();
        pacote.putString("signo",signo);
        notificar();
        exibirAlertDialog();
    }

}