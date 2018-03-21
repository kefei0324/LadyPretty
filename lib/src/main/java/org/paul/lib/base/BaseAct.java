package org.paul.lib.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import org.paul.lib.BuildConfig;
import org.paul.lib.manager.NetManager;
import org.paul.lib.manager.UiManager;

public abstract class BaseAct extends AppCompatActivity {

    protected String TAG = getClass().getSimpleName();
    private boolean hasWater;
    protected NetManager netManager = NetManager.getNetManager();
    protected Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState=savedInstanceState;
        setContentView(getLayoutId(savedInstanceState));
        bindUi();
    }

    /**
     * act视图id
     *
     * @return
     */
    protected abstract int getLayoutId(Bundle savedInstanceState);

    /**
     * 绑定视图
     */
    protected abstract void bindUi();

    /**
     * 视图绑定
     *
     * @param resId
     * @param <V>
     * @return
     */
    protected final <V extends View> V $(int resId) {
        return (V) findViewById(resId);
    }

    protected final <V extends View> V $(View view, int resId) {
        return (V) (view.findViewById(resId));
    }

    /**
     * 启动新act
     *
     * @param clz
     */
    protected void startAct(Class clz) {
        startWithData(clz, null);
    }

    protected final void startWithData(Class clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (null != bundle) {
            intent.putExtras(bundle);
            Log.d(TAG, "启动 " + clz.getSimpleName() + " bundle参数：" + bundle.toString());
        }
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        /************************************/
        /**
         * 显示水印
         */
        if (BuildConfig.DEBUG) {
            if (!hasWater && UiManager.getUiManager().isWaterOn()) {
                ViewGroup viewGroup = getRootView(this);
                viewGroup.addView(UiManager.getUiManager().initWater(this));
                hasWater = true;
            }
        }
        /************************************/
    }

    /**
     * 获取根视图
     *
     * @param activity
     * @return
     */
    private final ViewGroup getRootView(Activity activity) {
        return (ViewGroup) activity.findViewById(android.R.id.content);
    }


}
