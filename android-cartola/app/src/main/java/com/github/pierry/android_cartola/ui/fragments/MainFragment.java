package com.github.pierry.android_cartola.ui.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.astuetz.PagerSlidingTabStrip;
import com.github.pierry.android_cartola.R;
import com.github.pierry.android_cartola.ui.adapters.MainAdapter;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_main) public class MainFragment extends Fragment
    implements ViewPager.OnPageChangeListener {

  @ViewById PagerSlidingTabStrip tabs;
  @ViewById ViewPager pager;

  @AfterViews void init() {
    SystemBarTintManager tintManager = new SystemBarTintManager(getActivity());
    tintManager.setStatusBarTintEnabled(true);
    pager.setAdapter(new MainAdapter(getActivity().getSupportFragmentManager()));
    tabs.setViewPager(pager);
    tabs.setDividerColor(android.R.color.transparent);
    final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4,
        getResources().getDisplayMetrics());
    pager.setPageMargin(pageMargin);
    pager.setCurrentItem(0);
    changeColor(tabs, tintManager, getResources().getColor(R.color.colorPrimary));
    tabs.setOnPageChangeListener(this);
  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    LinearLayout layout = (LinearLayout) tabs.getChildAt(0);
    for (int i = 0; i < layout.getChildCount(); i++) {
      TextView tv = (TextView) layout.getChildAt(i);
      if (i == position) {
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
      } else {
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
      }
    }
  }

  @Override public void onPageSelected(int position) {

  }

  @Override public void onPageScrollStateChanged(int state) {

  }

  @UiThread public void changeColor(PagerSlidingTabStrip tabs, SystemBarTintManager tintManager,
      int newColor) {
    tabs.setBackgroundColor(newColor);
    tintManager.setTintColor(newColor);
  }
}
