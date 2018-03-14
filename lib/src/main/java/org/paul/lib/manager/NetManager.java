package org.paul.lib.manager;

import android.util.Log;
import com.google.gson.Gson;
import org.paul.lib.base.BaseBean;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class NetManager {
    private static final String TAG = NetManager.class.getSimpleName();
    private static final int READ_TIME = 4 * 1000;
    private static final int CONNECT_TIME = 4 * 1000;

    private static NetManager netManager = new NetManager();

    private NetManager() {
    }

    public static NetManager getNetManager() {
        return netManager;
    }

    public <T extends BaseBean> T post(String spec, Map<String, Object> params, Class<T> clz) {
        Log.d(TAG, "REQUEST URL :[" + spec + "]");
        try {
            HttpURLConnection connection = initHttp(spec, "POST", params);
            T t = handleResult(clz, connection);
            if (t != null) {
                Log.d(TAG, "REQUEST RET :" + t.toString());
                return t;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "ERROR IN NET EVENT, " + "error clz " + clz.getSimpleName());
        }
        return null;
    }

    public <T extends BaseBean> T get(String spec, Class<T> clz) {
        Log.d(TAG, "REQUEST URL :[" + spec + "]");
        try {
            HttpURLConnection connection = initHttp(spec, "GET", null);
            T t = handleResult(clz, connection);
            if (t != null) {
                Log.d(TAG, "REQUEST RET :" + t.toString());
                return t;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "ERROR IN NET EVENT, " + "error clz " + clz.getSimpleName());
        }
        return null;
    }

    private <T extends BaseBean> T handleResult(Class<T> clz, HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
                bos.flush();
            }
            bos.close();
            bos.toString("utf-8");
            return new Gson().fromJson(bos.toString("utf-8"), clz);
        }
        return null;
    }

    private HttpURLConnection initHttp(String spec, String method, Map<String, Object> params) throws IOException {
        HttpURLConnection connection = null;
        URL url = new URL(spec);
        if (isHttps(spec)) {
            connection = (HttpsURLConnection) url.openConnection();
        } else {
            connection = (HttpURLConnection) url.openConnection();
        }
        connection.setRequestMethod(method);
        connection.setConnectTimeout(CONNECT_TIME);
        connection.setReadTimeout(READ_TIME);
        connection.setUseCaches(false);
        initHeader(connection);
        initBody(connection, params);
        return connection;
    }

    private static String createParams(Map<String, Object> params) {
        Iterator<String> iterator = params.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Object value = params.get(key);
            Log.d(TAG, "createParams [params key " + key + " value " + value + "]");
            sb.append(key).append("=").append(value).append("&");
        }
        return sb.toString();
    }

    private HttpURLConnection initHeader(HttpURLConnection connection) {
        return connection;
    }

    private HttpURLConnection initBody(HttpURLConnection connection, Map<String, Object> params) throws IOException {
        if (null != params) {
            connection.setDoOutput(true);
            PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
            printWriter.write(createParams(params));
            printWriter.flush();
        }
        return connection;
    }

    private void handleHeader() {
        return;
    }

    private void handleBody() {
        return;
    }

    /**
     * 判断是否HTTPS请求
     *
     * @param spec
     * @return
     */
    private boolean isHttps(String spec) {
        spec = spec.toLowerCase(Locale.CHINA);//默认中国
        return spec.startsWith("https");
    }


}

