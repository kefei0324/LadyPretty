package org.paul.ladypretty.ui;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import org.paul.ladypretty.R;
import org.paul.ladypretty.ui.home.ChatsFrag;
import org.paul.ladypretty.ui.home.ContactsFrag;
import org.paul.ladypretty.ui.home.DiscoverFrag;
import org.paul.lib.base.BaseAct;
import org.paul.lib.base.BaseFrag;

import java.util.ArrayList;
import java.util.List;

public class HomeAct extends BaseAct {

    @Override
    protected int getLayoutId() {
        return R.layout.act_home;
    }

    @Override
    protected void bindUi() {

        BottomNavigationView bottomNavigationView = $(R.id.btmnv);
        ViewPager viewPager = $(R.id.vp);

        BaseFrag chatsFrag = new ChatsFrag();
        BaseFrag contactsFrag = new ContactsFrag();
        BaseFrag discoverFrag = new DiscoverFrag();
        final List<BaseFrag>fragList = new ArrayList<>();
        fragList.add(chatsFrag);
        fragList.add(contactsFrag);
        fragList.add(discoverFrag);
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }
        };
        viewPager.setAdapter(pagerAdapter);


    }
}
