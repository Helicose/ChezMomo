package com.controle_android.chezmomo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("commandes", MODE_PRIVATE);
        sharedPreferences
                .edit()
                .putStringSet("commandes", null)
                .putStringSet("prix", null)
                .apply();

        final ListView liste;

        String[] data = new String[]{
                "Nos Formules","A la carte", "Carte des vins"
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        TextView bonAppetit = (TextView) findViewById(R.id.bonAppetit);
        setFont(bonAppetit,"ClickerScript-Regular.ttf");

        liste = (ListView)findViewById(R.id.list);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent formules = new Intent(MainActivity.this, Formules.class); // on declare la nouvelle activite
                    startActivity (formules); //on demarre l'activite
                }else{
                    if(position==1){
                        Intent carte = new Intent(MainActivity.this, Carte.class); // on declare la nouvelle activite
                        startActivity (carte); //on demarre l'activite
                    }
                    else if(position==2){
                        Intent vins = new Intent(MainActivity.this, Vins.class); // on declare la nouvelle activite
                        startActivity (vins); //on demarre l'activite
                    }
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.commande:
                Intent commande = new Intent(MainActivity.this, Commande.class); // on declare la nouvelle activite
                startActivity (commande); //on demarre l'activite
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setFont(TextView textView, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }

}

