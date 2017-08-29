package fr.prepavenir.guide.ui.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.prepavenir.guide.R;
import fr.prepavenir.guide.ui.listing.ListingActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showRestaurant(View view) {
        //les intents permet de communiquer et de passer des parametres qui est proche du post. intent fait partit de android
        //on met ennsuite en premier argument l'expiditeur et en deuxieme argument le recepteur
        Intent intentRestaurant = new Intent(HomeActivity.this, ListingActivity.class);

        //passage des parametres avec un systeme de cles avec sa valeur
        intentRestaurant.putExtra("isRestaurant", true);

    //le start activity déclenche l'ouveture de la page
        startActivity(intentRestaurant);
    }

    public void showHotel(View view) {
        Intent intentHotel = new Intent(HomeActivity.this, ListingActivity.class);

        //passage des parametres avec un systeme de cles avec sa valeur
        intentHotel.putExtra("isRestaurant", false);

        startActivity(intentHotel);

    }
}
