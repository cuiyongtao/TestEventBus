package cm.cui.testeventbus.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import cm.cui.testeventbus.R;
import cm.cui.testeventbus.bean.MessageEvent;

/**
 * @author:Victory
 * @time: 2018/3/26
 * @explain;
 */

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button first;
    String str="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        first = findViewById(R.id.first);
        first.setText("测试广播");
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });
        text = findViewById(R.id.text);
    }


    @Subscribe()
    public void getMessage(MessageEvent messageEvent) {
        str += messageEvent.getMessage();
        text.setText(str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        stopService(new Intent(MainActivity.this, MyService.class));
    }
}
