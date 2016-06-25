package com.github.pierry.android_cartola.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.github.pierry.android_cartola.ui.fragments.MainFragment;
import com.github.pierry.android_cartola.ui.fragments.MainFragment_;
import com.github.pierry.android_cartola.ui.fragments.TeamFragment_;

public class MainAdapter extends FragmentPagerAdapter {

  final int PAGE_COUNT = 2;
  private String tabTitles[] = new String[] { "Equipes", "Favoritos"};

  public MainAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public int getCount() {
    return PAGE_COUNT;
  }

  @Override public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return new TeamFragment_();
      case 1:
        return new TeamFragment_();
    }
    return new TeamFragment_();
  }

  @Override public CharSequence getPageTitle(int position) {
    return tabTitles[position];
  }
}