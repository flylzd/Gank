package com.blackcat.gank;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.blackcat.gank.api.API;
import com.blackcat.gank.base.BaseActivity;
import com.blackcat.gank.bean.User;
import com.blackcat.gank.utils.StatusBarCompat;
import com.blackcat.gank.utils.ToastUtil;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseActivity {

    private static final String ACTION_EXIT = "action.exit";
    private ExitReceiver exitReceiver = new ExitReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        registerExitReceiver();

//        API.getApiService().getBaidu().enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Response<User> response, Retrofit retrofit) {
////                System.out.println(response.body().toString());
//                System.out.println("respinse " + response.body().toString());
////                response.body()
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                System.out.println("Throwable " + t.toString());
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exitReceiver);
    }

    private void registerExitReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_EXIT);
        registerReceiver(exitReceiver, filter);
    }

    class ExitReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            MainActivity.this.finish();
        }
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.showShort("再按一次退出应用");
                exitTime = System.currentTimeMillis();
            } else {
                exit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        startActivity(new Intent(MainActivity.this,MainActivity.class));
        Intent intent= new Intent();
        intent.setAction(ACTION_EXIT);
        sendBroadcast(intent);
    }

}
