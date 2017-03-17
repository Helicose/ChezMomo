package com.controle_android.chezmomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Vins extends AppCompatActivity {

    Intent commandes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vins);
        setTitle("A la vôtre !");


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
        switch (item.getItemId()) {
            case R.id.commande:
                Intent commande = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                startActivity(commande); //on demarre l'activite
                return true;
            case R.id.menu:
                Intent menu = new Intent(Vins.this, MainActivity.class); // on declare la nouvelle activite
                startActivity (menu); //on demarre l'activite
                return true;
            case R.id.formules:
                Intent formules = new Intent(Vins.this, Formules.class); // on declare la nouvelle activite
                startActivity (formules); //on demarre l'activite
                return true;
            case R.id.vins:
                Intent vins = new Intent(Vins.this, Vins.class); // on declare la nouvelle activite
                startActivity (vins); //on demarre l'activite
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void ajoutVin(View vue) {
        int prix;
        String nom;

        switch (vue.getId()) {
            case R.id.carteChablis:
                prix = 41;
                nom = "AOP Chablis 1er cru 75cl";
                commandes = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity(commandes); //on demarre l'activite
                break;

            case R.id.carteGerwurztraminer:
                prix = 48;
                nom = "AOP Gerwurztraminer 'Ostenberg' 75cl";

                commandes = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity(commandes); //on demarre l'activite
                break;

            case R.id.carteHautmedoc:
                prix = 54;
                nom = "AOP Haut-Médoc 75cl";

                commandes = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity(commandes); //on demarre l'activite
                break;

            case R.id.carteMedoc:
                prix = 50;
                nom = "AOP Médoc 75cl";

                commandes = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity(commandes); //on demarre l'activite
                break;

            case R.id.carteBeaune:
                prix = 52;
                nom = "AOP Beaune 75cl";

                commandes = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity(commandes); //on demarre l'activite
                break;

            case R.id.carteMadiran:
                prix = 38;
                nom = "AOP Madiran 75cl";

                commandes = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity(commandes); //on demarre l'activite
                break;

            case R.id.carteProvence:
                prix = 42;
                nom = "AOP Côtes de Provence 75cl";

                commandes = new Intent(Vins.this, Commande.class); // on declare la nouvelle activite
                commandes.putExtra("nom", nom);
                commandes.putExtra("prix", prix);
                startActivity(commandes); //on demarre l'activite
                break;
        }
    }
}