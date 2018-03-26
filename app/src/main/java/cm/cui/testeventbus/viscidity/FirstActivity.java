package cm.cui.testeventbus.viscidity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import cm.cui.testeventbus.R;
import cm.cui.testeventbus.bean.MessageEvent;

/**
 * @author:Victory
 * @time: 2018/3/26
 * @explain;
 */

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setMessage("测试粘性事件");
                EventBus.getDefault().postSticky(messageEvent);
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }
}
