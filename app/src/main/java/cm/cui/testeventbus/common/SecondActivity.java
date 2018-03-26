package cm.cui.testeventbus.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import cm.cui.testeventbus.R;
import cm.cui.testeventbus.bean.MessageEvent;

/**
 * @author:Victory
 * @time: 2018/3/22
 * @explain;
 */

public class SecondActivity extends AppCompatActivity {
    private Button first;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        first = findViewById(R.id.first);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageEvent event = new MessageEvent();
                event.setMessage("测试测试测试");
                EventBus.getDefault().post(event);
                finish();
            }
        });
    }
}
