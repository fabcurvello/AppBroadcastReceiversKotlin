package br.com.fabriciocurvello.appbroadcastreceiverskotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        // Verifica a conectividade da rede
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting

        // Exibir uma mensagem toast
        if (isConnected) {
            Toast.makeText(context, "Network Connected", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Network Disconnected", Toast.LENGTH_SHORT).show()
        }
    }
}