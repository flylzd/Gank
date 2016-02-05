package com.blackcat.gank;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.blackcat.gank.api.API;
import com.blackcat.gank.base.BaseActivity;
import com.blackcat.gank.bean.User;
import com.blackcat.gank.utils.StatusBarCompat;
import com.blackcat.gank.utils.ToastUtil;

import butterknife.Bind;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseActivity {

    private static final String ACTION_EXIT = "action.exit";
    private ExitReceiver exitReceiver = new ExitReceiver();

    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Bind(R.id.navigationView)
    NavigationView navigationView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {

        registerExitReceiver();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

//        StatusBarCompat.compat(this);
//        StatusBarCompat.compat(this, getResources().getColor(R.color.colorAccent));


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

        API.getApiService().getBaidu().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {

//                System.out.println("response " + response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
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
