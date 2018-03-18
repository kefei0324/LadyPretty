package org.paul.ladypretty.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import org.paul.ladypretty.R;
import org.paul.lib.base.BaseAct;

/**
 * AUTHOR Paul
 * DATE 2018/3/18
 */
public class MenuAct extends BaseAct implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected int getLayoutId() {
        return R.layout.act_menu;
    }

    @Override
    protected void bindUi() {

        Toolbar toolbar = $(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = $(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MenuAct.this, drawer, toolbar, R.string.app_name, R.string.app_name_closed);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = $(R.id.nv_left);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
