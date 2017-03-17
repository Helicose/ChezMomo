package com.controle_android.chezmomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.astuetz.PagerSlidingTabStrip;

public class Carte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carte);
        setTitle("Choix à la carte !");
        Intent intent = getIntent();

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
    }

    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[] { "Entrées", "Plats", "Desserts" };

        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return CarteEntrees.newInstance(position + 1);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return CartePlats.newInstance(position + 1);
                case 2: // Fragment # 1 - This will show SecondFragment
                    return CarteDesserts.newInstance(position + 1);
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu, menu);
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.commande:
                Intent commande = new Intent(Carte.this, Commande.class); // on declare la nouvelle activite
                startActivity (commande); //on demarre l'activite
                finish();
                return true;
            case R.id.menu:
                Intent menu = new Intent(Carte.this, MainActivity.class); // on declare la nouvelle activite
                startActivity (menu); //on demarre l'activite
                finish();
                return true;
            case R.id.formules:
                Intent formules = new Intent(Carte.this, Formules.class); // on declare la nouvelle activite
                startActivity (formules); //on demarre l'activite
                finish();
                return true;
            case R.id.vins:
                Intent vins = new Intent(Carte.this, Vins.class); // on declare la nouvelle activite
                startActivity (vins); //on demarre l'activite
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}