package com.github.pierry.android_cartola;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.github.pierry.android_cartola.api.TeamApi;
import com.github.pierry.android_cartola.domain.Team;
import com.github.pierry.android_cartola.domain.contracts.ITeamApi;
import com.github.pierry.android_cartola.domain.contracts.ITeamRepository;
import com.github.pierry.android_cartola.repositories.TeamRepository;
import com.github.pierry.android_cartola.ui.adapters.TeamAdapter;
import com.github.pierry.android_cartola.ui.fragments.MainFragment_;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import java.util.List;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main) public class MainActivity extends AppCompatActivity {

  @ViewById Toolbar toolbar;

  @AfterViews void init(){
    toolbar.setTitle("Cartola Test");
    setSupportActionBar(toolbar);
    loadDrawer();
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    MainFragment_ fragment = new MainFragment_();
    transaction.replace(R.id.content_fragment, fragment);
    transaction.commit();
  }

  @UiThread void loadDrawer() {
    PrimaryDrawerItem home = new PrimaryDrawerItem().withName("Home");
    new DrawerBuilder().withActivity(this)
        .withToolbar(toolbar)
        .withHasStableIds(true)
        .withTranslucentStatusBar(true)
        .withSelectedItem(-1)
        .addDrawerItems(home)
        .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
          @Override public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            switch (position) {
              case 1:

                return true;
              default:
                return true;
            }
          }
        })
        .build();
  }
}
