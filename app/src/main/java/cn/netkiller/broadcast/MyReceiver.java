package cn.netkiller.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "程序已启动", Toast.LENGTH_SHORT).show();
//        String data = intent.getStringExtra("msg");
//        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
