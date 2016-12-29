package com.shido.broadcastandpermissions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class IncomingReceiver extends BroadcastReceiver {
    public IncomingReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

       String state =  intent.getStringExtra(TelephonyManager.EXTRA_STATE); //Retorna o State do cel

        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            Toast.makeText(context, "Ringing State", Toast.LENGTH_SHORT).show();
        }

        if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
            Toast.makeText(context, "Call received", Toast.LENGTH_SHORT).show();
        }

        if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
            Toast.makeText(context, "Idle State", Toast.LENGTH_SHORT).show();
        }

    }
}
