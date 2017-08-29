package fr.prepavenir.guide.ui.listing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.prepavenir.guide.R;
import fr.prepavenir.guide.ui.details.detailsActivity;
import fr.prepavenir.guide.models.Hotel;
import fr.prepavenir.guide.models.Restaurant;

public class ListingActivity extends AppCompatActivity {

    //declaration des propriétés
    private TextView TextViewTitle;
    private GridView gridViewData;

    //declarer la list de restaurant et de l'initialiser
    private List<Restaurant> restaurantList = new ArrayList<>();//initialisation de la liste

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        TextViewTitle = (TextView) findViewById(R.id.TextViewTitle);
        gridViewData = (GridView) findViewById(R.id.gridViewData);

        //verifier si des données (extra) ont été envoyés
        if (getIntent().getExtras() != null) {

            //permet de verifier si les données ont ete envoyé . récuperation de la clef et sa valeur : true / false
            boolean isRestaurant = getIntent().getExtras().getBoolean("isRestaurant");

            if (isRestaurant) {//true
                TextViewTitle.setText(getString(R.string.listing_title_restaurant));

                //ajouter des restaurants dans la liste
                restaurantList.add(new Restaurant("La crémaillaire", "Gastronomique", "info@cremaillaire.fr", "0245789541", "http://google.fr", "https://u.tfstatic.com/restaurant_photos/778/1778/169/612/4bc9085ae38cc520876015f6e5065663.jpg"));
                restaurantList.add(new Restaurant("La Marée Bleu", "Gastronomique", "info@maréeBleu.fr", "0245789500", "http://google.fr", "https://media-cdn.tripadvisor.com/media/photo-s/05/53/0a/55/le-gastronomique-restaurant.jpg"));
                restaurantList.add(new Restaurant("Le Fouqets", "Gastronomique", "info@fouquets.fr", "0245789571", "http://google.fr", "http://monparisjoli.com/wp-content/uploads/2015/10/le-fouquets-825x510.jpg"));
                restaurantList.add(new Restaurant("La Criée", "Gastronomique", "info@criée.fr", "0245789541", "http://google.fr", "http://image-restaurant.linternaute.com/image/550/la-criee-99693.jpg"));

                //l'adapter sert a afficher les informations. il est declarer ici puis il sera l'exension de la classe restaurant adapter
               // gridViewData.setAdapter(new ArrayAdapter<Restaurant>(ListingActivity.this, android.R.layout.simple_list_item_1, restaurantList));
                //gridViewData.setNumColumns(2);
                gridViewData.setAdapter(new RestaurantAdapter(ListingActivity.this, R.layout.item_restaurant, restaurantList));

                //on place un ecouteur OnItem pour savoir quel entete a ete cliquer
                gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        //on transemet les parametres par la classe Intent avec en parametre l'expidditeur et le recepteur
                        Intent myIntent =new Intent(ListingActivity.this, detailsActivity.class);

                        //récupération de l'objet restaurant
                        Restaurant objet = restaurantList.get(position);

                        //envoyer les informations
                        myIntent.putExtra("title", objet.getName());
                        myIntent.putExtra("category", objet.getCategory());
                        myIntent.putExtra("email", objet.getEmail());
                        myIntent.putExtra("phone", objet.getPhone());
                        myIntent.putExtra("url", objet.getUrl());
                        myIntent.putExtra("image", objet.getImage());
                        //etc...

                        startActivity(myIntent);
                    }
                });

            } else {//false
                TextViewTitle.setText(R.string.listing_title_hotel);

                //ajouter les hotels
                final List<Hotel> hotelList = new ArrayList<>();

                hotelList.add(new Hotel("Ibis", "Discount", "info@ibis.fr", "01 45 24 14 47", "http://www.ibis.fr", "3", "http://www.ahstatic.com/photos/2351_ro_00_p_346x260.jpg"));
                hotelList.add(new Hotel("mercure", "confortable", "info@mercure.fr","01 45 24 14 47", "http://www.mercure.fr", "5", "http://www.hotel-omaha-beach.com/wp-content/uploads/2016/03/Hotel-Mercure-Omaha-Beach-Chambre-Standard-5.jpg"));
                hotelList.add(new Hotel("formule1", "moyen", "info@ibis.fr","01 45 24 14 47", "http://www.ibis.fr", "2", "http://www.ahstatic.com/photos/2447_ho_02_p_230x210.jpg"));

                gridViewData.setAdapter(new HotelAdapter(ListingActivity.this, R.layout.item_hotel, hotelList));

                gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intentHotel = new Intent(ListingActivity.this, detailsActivity.class);

                        //passage des informations
                        intentHotel.putExtra("title", hotelList.get(i).getName());
                        intentHotel.putExtra("category", hotelList.get(i).getCategory());
                        intentHotel.putExtra("email", hotelList.get(i).getEmail());
                        intentHotel.putExtra("phone", hotelList.get(i).getPhone());
                        intentHotel.putExtra("url", hotelList.get(i).getUrl());
                        intentHotel.putExtra("image", hotelList.get(i).getImage());
                        intentHotel.putExtra("stars", hotelList.get(i).getStars());

                        startActivity(intentHotel);
                    }
                });
            }
        }
    }
}
