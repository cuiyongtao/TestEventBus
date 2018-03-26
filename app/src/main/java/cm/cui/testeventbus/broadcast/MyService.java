package cm.cui.testeventbus.broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

import cm.cui.testeventbus.bean.MessageEvent;

/**
 * @author:Victory
 * @time: 2018/3/26
 * @explain;
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        try {
            runnable.run();
        } catch (Exception e) {

        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            /**
             * 线程启动后，模拟特定条件发送广播
             */
            MessageEvent messageEvent = new MessageEvent();
            for (int i = 0; i < 100; i++) {
                if (i % 13 == 0) {
                    messageEvent.setMessage("i=" + i + ",");
                    //发送消息
                    EventBus.getDefault().post(messageEvent);
                } else if (i == 99) {
                    messageEvent.setMessage("我是最后一条数据");
                    //发送消息
                    EventBus.getDefault().post(messageEvent);
                }
            }
        }
    };


}
