package com.shido.broadcastandpermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Para permissões do tipo dangerous na API 23 necessita de permissões especiais que devem ser pedidas aqui
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE); // Retorna um int com a permissão
            if(permissionCheck!= PackageManager.PERMISSION_GRANTED){ //Se ele nao tiver permitido já essa permissão
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_PHONE_STATE}, 19); // Pedindo a permissão colocando no array a lista de permissões e passando um request code

            }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            //Caso
            case 19:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Quando a permissão for concedida o array é maior que zero
                    //Checando a primeira posição  = READ_PHONE_STATE
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    //Perform some actioon

                }else{
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                    //Disable the task related to permission
                }
        }
    }
}
