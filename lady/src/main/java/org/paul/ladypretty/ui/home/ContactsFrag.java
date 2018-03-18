package org.paul.ladypretty.ui.home;

import android.view.View;
import org.paul.ladypretty.R;
import org.paul.ladypretty.ui.MenuAct;
import org.paul.lib.base.BaseFrag;

/**
 * AUTHOR Paul
 * DATE 2018/3/18
 */
public class ContactsFrag extends BaseFrag implements View.OnClickListener {
    @Override
    public int getLayoutId() {
        return R.layout.frag_contacts;
    }

    @Override
    protected void bindUi() {

        $(R.id.tv_).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_:
                startAct(MenuAct.class);
                break;
        }
    }
}
