package org.paul.ladypretty.ui.map;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.google.android.gms.maps.MapView;

public class MyMapView extends MapView {
    private static String TAG=MyMapView.class.getSimpleName();
    public MyMapView(Context context) {
        this(context, null);
    }

    public MyMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return true;
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG,"onInterceptTouchEvent ev isIntercept="+super.onInterceptTouchEvent(ev));

        return super.onInterceptTouchEvent(ev);
//                return true;

    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.d(TAG,"dispatchTouchEvent ev action="+ev.getAction());
//        return true;
//    }
}
