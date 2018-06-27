package lav.c;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;

import static lav.c.R.layout.fragment_first;

/**
 * Created by Ashwin on 3/2/2018.
 */

public class Extras extends AppCompatActivity {
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extras);

        getSupportActionBar().setTitle(Html.fromHtml("<h1><font color='#ffffff' ><b>C </b><i>Programming</i></font></h1>"));

        tab=(TabLayout)findViewById(R.id.simpleTabLayout);
        final TabLayout.Tab first = tab.newTab();
        first.setText(R.string.reference);
        first.setIcon(R.drawable.reference);
        tab.addTab(first);

        tab=(TabLayout)findViewById(R.id.simpleTabLayout);
        TabLayout.Tab second = tab.newTab();
        second.setText(R.string.status);
        second.setIcon(R.drawable.status);
        tab.addTab(second);

        tab.getTabAt(R.layout.fragment_first);
        first.select();

        Fragment fragment = new FirstFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.simpleFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();


        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment = new FirstFragment();
                        break;
                    case 1:
                        fragment = new SecondFragment();
                        break;
                }


                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e("RE","reee");
            }
        });
    }
}
