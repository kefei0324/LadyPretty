package org.paul.ladypretty.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import org.paul.ladypretty.BuildConfig;
import org.paul.ladypretty.R;
import org.paul.ladypretty.ui.bean.Login;
import org.paul.ladypretty.ui.bean.RegionList;
import org.paul.ladypretty.ui.bean.UnReadMsg;
import org.paul.lib.base.BaseAct;
import org.paul.lib.base.Constants;
import org.paul.lib.manager.SPManager;
import org.paul.lib.manager.ThreadManager;

import java.util.HashMap;
import java.util.Map;

public class NetTesterAct extends BaseAct implements View.OnClickListener {
    private static final int EMPTY_RESPONSE = 0x10;
    private static final int UNREAD_MSG = 0x11;
    private static final int REGION_LIST = 0x13;
    private static final int LOGIN = 0x14;

    private TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.act_nettester;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String spec = "";
            switch (msg.what) {
                case UNREAD_MSG:
                    spec = ((UnReadMsg) msg.obj).toString();
                    tv.setText(spec);
                    break;
                case EMPTY_RESPONSE:
                    tv.setText(R.string.empty);
                    break;
                case LOGIN:
                    Login login = (Login) msg.obj;
                    spec = login.toString();
                    tv.setText(spec);
                    if (login.getCode() == 1) {
                        SPManager.setString(NetTesterAct.this, "token", login.getData().getToken().getTid());
                        Constants.setTOKEN(login.getData().getToken().getTid());
                    }
                    break;
                case REGION_LIST:
                    spec = ((RegionList) msg.obj).toString();
                    tv.setText(spec);
                    break;
            }
        }
    };

    @Override
    protected void bindUi() {

        $(R.id.btn).setOnClickListener(this);
        $(R.id.btn_2).setOnClickListener(this);
        $(R.id.btn_3).setOnClickListener(this);
        tv = $(R.id.tv);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                request();
                break;
            case R.id.btn_2:
                requestRegion();
                break;
            case R.id.btn_3:
                requestLogin();
                break;
        }
    }

    private void requestLogin() {
        ThreadManager.getThreadManager().submit(new Runnable() {
            @Override
            public void run() {
                Login login = netManager.post(BuildConfig.API_HOST + "/account/account/v1/login", createLogin(), Login.class);
                if (null != login)
                    handler.obtainMessage(LOGIN, login).sendToTarget();
                else
                    handler.obtainMessage(EMPTY_RESPONSE).sendToTarget();
            }
        });
    }

    private Map<String, Object> createLogin() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", "aaa.@google.com");
        params.put("password", "sfddfecvwewe");
        params.put("loginType", "EM");
        return params;
    }

    private void requestRegion() {

        ThreadManager.getThreadManager().submit(new Runnable() {
            @Override
            public void run() {
                RegionList regionList = netManager.get(BuildConfig.API_HOST + "/sysmgmt/sysmgmt/v1/dictionaries/DIC_CM_COUNTRY/zh-CN", RegionList.class);
                if (null != regionList)
                    handler.obtainMessage(REGION_LIST, regionList).sendToTarget();
                else
                    handler.obtainMessage(EMPTY_RESPONSE).sendToTarget();
            }
        });
    }

    private void request() {

        ThreadManager.getThreadManager().submit(new Runnable() {
            @Override
            public void run() {
                UnReadMsg unReadMsg = netManager.post(BuildConfig.API_HOST + "/notification/notification/v1/notifications/query", createParams(), UnReadMsg.class);
                if (null != unReadMsg)
                    handler.obtainMessage(UNREAD_MSG, unReadMsg).sendToTarget();
                else
                    handler.obtainMessage(EMPTY_RESPONSE).sendToTarget();
            }
        });

    }

    private Map<String, Object> createParams() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("unifyID", "110001");
        params.put("serviceType", "11");
        params.put("notifyType", "0");
        params.put("receiver", "18012989588");
        params.put("noticeStatus", "1");
        params.put("readStatus", "1");
        return params;
    }
}
