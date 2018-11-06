package cn.netkiller.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取LocalBroadcastManger 单li实例
        localBroadcastManager = localBroadcastManager.getInstance(this);

        intentFilter = new IntentFilter();
        intentFilter.addAction("cn.netkiller.broadcast.MESSAGE");
        myBroadcastReceiver = new MyBroadcastReceiver();
        //注册本地广播接收器
        localBroadcastManager.registerReceiver(myBroadcastReceiver, intentFilter);

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("Send");

                Intent intent = new Intent();
                intent.setAction("cn.netkiller.broadcast.MESSAGE");
                intent.putExtra("msg", "http://www.netkiller.cn");
                //发送本地广播
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销本地广播接收器
        localBroadcastManager.unregisterReceiver(myBroadcastReceiver);
    }

    //自定义内部类，继承 BroadcastReceiver
    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            String data = intent.getStringExtra("msg");
            Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

        }
    }
}
