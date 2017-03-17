package com.controle_android.chezmomo;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView liste;

        String[] data = new String[]{
                "Nos Formules","A la carte", "Tous nos vins"
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );

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

}

/*
private View.OnClickListener lienInventaire = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inventaire = new Intent (MainActivity.this, Inventaire.class); // on declare la nouvelle activite reliee au bouton
            startActivity (inventaire); //on demarre l'activite
        }

    };

 */
