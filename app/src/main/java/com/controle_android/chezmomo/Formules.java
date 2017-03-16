package com.controle_android.chezmomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Formules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formules);
        setTitle("Nos formules");

    }

    public void redirectionFormule(View vue){
        switch (vue.getId()) {
            case R.id.carteCampagne:
                Intent carte = new Intent(Formules.this, Carte.class); // on declare la nouvelle activite
                startActivity (carte); //on demarre l'activite
                break;
            case R.id.carteHackenberg:
                Intent carte2 = new Intent(Formules.this, Carte.class); // on declare la nouvelle activite
                startActivity (carte2); //on demarre l'activite
                break;
            case R.id.cartemidi:
                Intent menuMidi = new Intent(Formules.this, CarteMidi.class); // on declare la nouvelle activite
                startActivity (menuMidi); //on demarre l'activite
                break;
            case R.id.cartepetiots:
                Intent menuPetiots = new Intent(Formules.this, CartePetiots.class); // on declare la nouvelle activite
                startActivity (menuPetiots); //on demarre l'activite
                break;
        }

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
                Intent commande = new Intent(Formules.this, Commande.class); // on declare la nouvelle activite
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
