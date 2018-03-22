package org.paul.ladypretty.ui;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import org.paul.ladypretty.R;
import org.paul.lib.base.BaseAct;

public class LabAct extends BaseAct implements OnMapReadyCallback {

//    private CoordinatorLayout coordinator;
    private GoogleMap mMap;
    private NestedScrollView nestedScrollView;
//    private CollapsingToolbarLayout toolbarLayout;

    private CollapsingToolbarLayoutState state;
    private MapView mMapView;
    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }
    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.act_lab;
    }
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    public boolean canFlow;

    @Override
    protected void bindUi() {

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//        coordinator=$(R.id.coordinator);
        mMapView = $(R.id.map);
        Bundle mapBundle =null;
                if(null!=savedInstanceState) {
                 mapBundle=   savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
                }
        mMapView.onCreate(mapBundle);
        mMapView.getMapAsync(this);
//        mMapView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(canFlow){
//                    return true;
//                }else {
//                    return false;
//                }
//            }
//        });
        $(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
//                toolbarLayout.setNestedScrollingEnabled(true);
//                canFlow=false;
                nestedScrollView.setNestedScrollingEnabled(true);
//                mMapView.setNestedScrollingEnabled(true);
//                appBarLayout.setNestedScrollingEnabled(true);
            }
        });
        $(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
//                toolbarLayout.setNestedScrollingEnabled(false);
//                canFlow=true;
                nestedScrollView.setNestedScrollingEnabled(false);
//                mMapView.setNestedScrollingEnabled(false);
//                appBarLayout.setNestedScrollingEnabled(false);
            }
        });
//        mMapView.setOnTouchListener(new View.OnTouchListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                appBarLayout.setNestedScrollingEnabled(false);
//                return false;
//            }
//        });
        nestedScrollView = $(R.id.nest);
//        toolbarLayout = $(R.id.toolbarlayout);
//        appBarLayout = $(R.id.app_bar);
//        appBarLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return false;
//            }
//        });
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (verticalOffset == 0) {
//                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
//                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
//                        toolbarLayout.setTitle("EXPANDED");//设置title为EXPANDED
////                        toolbarLayout.setNestedScrollingEnabled(false);
////                        nestedScrollView.setNestedScrollingEnabled(false);
//                    }
//                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
//                        toolbarLayout.setTitle("");//设置title不显示
////                        playButton.setVisibility(View.VISIBLE);//隐藏播放按钮
//                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
////                        toolbarLayout.setNestedScrollingEnabled(true);
////                        nestedScrollView.setNestedScrollingEnabled(true);
//                    }
//                } else {
//                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
//                        if(state == CollapsingToolbarLayoutState.COLLAPSED){
////                            playButton.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
//                        }
//                        toolbarLayout.setTitle("INTERNEDIATE");//设置title为INTERNEDIATE
//                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
//
//                    }
//                }
//
//            }
//        });
//        nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                appBarLayout.setNestedScrollingEnabled(true);
//                return false;
//            }
//        });
//        mMapView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.d(TAG,"mMapView onTouchListener");
//                return false;
//            }
//        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng hk = new LatLng(22.2988123, 114.1721746);
//        mMap.addMarker(new MarkerOptions().position(hk).title("Marker in HK"));
        CameraPosition build = new CameraPosition.Builder().target(hk)
                .zoom(13f)
                .bearing(0)
                .tilt(0)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(build));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(hk));
//        boolean success = googleMap.setMapStyle(new MapStyleOptions(getString(R.string.style_json)));
//
//        if (!success) {
//            Log.d(TAG, "Style parsing failed.");
//        }
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

//        LatLng sydney = new LatLng(/*-33.852, 151.211*/22.2988123,114.1721746);
//        googleMap.addMarker(new MarkerOptions().position(sydney)
//                .title("Marker in Sydney"));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void changeCamera(CameraUpdate update/*, GoogleMap.CancelableCallback callback*/) {
//        if (mAnimateToggle.isChecked()) {
//            if (mCustomDurationToggle.isChecked()) {
//                int duration = mCustomDurationBar.getProgress();
        // The duration must be strictly positive so we make it at least 1.
//                mMap.animateCamera(update, Math.max(duration, 1), callback);
//            } else {
//        mMap.animateCamera(update, callback);
//            }
//        } else {
        mMap.moveCamera(update);
//        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

//    @Override
//    public void onMapReady(GoogleMap map) {
//        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
//    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
