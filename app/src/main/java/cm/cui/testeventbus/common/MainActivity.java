package cm.cui.testeventbus.common;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import cm.cui.testeventbus.R;
import cm.cui.testeventbus.bean.MessageEvent;

public class MainActivity extends AppCompatActivity {

    private Button first;
    private Button second;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        first = findViewById(R.id.first);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(inten);
            }
        });
        text = findViewById(R.id.text);
    }

    @Subscribe()
    public void testEvent(MessageEvent messageEvent) {
        text.setText(messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }
}
