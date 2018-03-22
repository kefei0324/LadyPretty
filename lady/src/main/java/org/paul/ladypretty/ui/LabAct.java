package org.paul.ladypretty.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import org.paul.ladypretty.R;
import org.paul.lib.base.BaseAct;

public class LabAct extends BaseAct implements OnMapReadyCallback {

    private GoogleMap mMap;
    private NestedScrollView nestedScrollView;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout toolbarLayout;

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.act_lab;
    }

    @Override
    protected void bindUi() {

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
//        MapView mapView =$(R.id.map);
//        Toolbar toolbar = $(R.id.toolbar);
        nestedScrollView = $(R.id.nest);
        toolbarLayout = $(R.id.toolbarlayout);
        appBarLayout = $(R.id.app_bar);
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (verticalOffset == 0) {
//                    nestedScrollView.setNestedScrollingEnabled(false);
//                } else {
//                    nestedScrollView.setNestedScrollingEnabled(true);
//                }
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
                            this, R.raw.mapstyle_grayscale));

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
}
