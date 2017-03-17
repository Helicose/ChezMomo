package com.controle_android.chezmomo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class Formules extends AppCompatActivity {

    Intent commandes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formules);
        setTitle("Nos formules");
        //intent.extra

    }

    public void redirectionFormule(View vue){
        int prix;
        String nom;

        switch (vue.getId()) {
            case R.id.carteCampagne:
                prix = 14;
                nom = "Menu Campagne";
                commandes = new Intent(Formules.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity (commandes); //on demarre l'activite
                break;

            case R.id.carteHackenberg:
                prix = 29;
                nom = "Menu Hackenberg";

                commandes = new Intent(Formules.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity (commandes); //on demarre l'activite
                break;

            case R.id.cartemidi:
                prix = 12;
                nom = "Menu Midi";

                commandes = new Intent(Formules.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity (commandes); //on demarre l'activite
                break;

            case R.id.cartepetiots:
                prix = 8;
                nom = "Menu des Petiots";

                commandes = new Intent(Formules.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity (commandes); //on demarre l'activite
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
