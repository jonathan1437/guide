package fr.prepavenir.guide.ui.details;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.prepavenir.guide.R;

public class detailsActivity extends AppCompatActivity {

    private ImageView imageViewPhoto;
    private TextView textViewTitle, textviewCategory, textViewStars;
    private Button buttonEmail, buttonPhone, buttonUrl;


    //fonction pour que la fleche de retour soit activée
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
               // finish();
                onBackPressed();//méthode de retour physique sur le telephone
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        //affichage de fleche de retour
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textviewCategory = (TextView) findViewById(R.id.textViewCategory);
        textViewStars = (TextView) findViewById(R.id.textViewStars);
        buttonEmail = (Button) findViewById(R.id.buttonEmail);
        buttonPhone = (Button) findViewById(R.id.buttonPhone);
        buttonUrl = (Button) findViewById(R.id.buttonUrl);

        //récupération des données en recuperant la clef qui a ete passer
        if (getIntent().getExtras() !=null);
        String title = getIntent().getExtras().getString("title");
        String category = getIntent().getExtras().getString("category");
        String email = getIntent().getExtras().getString("email");
        String phone = getIntent().getExtras().getString("phone");
        String url = getIntent().getExtras().getString("url");
        String image = getIntent().getExtras().getString("image");
        String stars = getIntent().getExtras().getString("stars");

        //afficher le titre
        textViewTitle.setText(title);
        textviewCategory.setText(category);
        buttonEmail.setText(email);
        buttonPhone.setText(phone);
        buttonUrl.setText(url);

        //affichage du nombre d'étoile pour les hotels
        if (stars !=null) {
            textViewStars.setVisibility(View.VISIBLE);//rendre visible la zone "stars"
            textViewStars.setText(String.format(getString(R.string.listing_hotel_hotel), stars));
        }else {
            textViewStars.setVisibility(View.GONE);//rendre invisible la zone "stars"
        }
        //pour afficher l'image on utilise la bibliotheque piccasso
        //premier argument le context cad la page ou tu te trouve
        //load c'est l'url http que l'on preciser dans la variable listRestaurant
        //into est le lieu ou l'image doit etre charger
        Picasso.with(detailsActivity.this)
                .load(image)
                .into(imageViewPhoto);

        //pour que picasso puisse charger l'image il faut aller dans le manifest pour que picasso soit autoriser a charger l'image



        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pour lancer l'application mail
                Intent intentEmail = new Intent(Intent.ACTION_SEND);

                //filtrer les application de messagerie
                intentEmail.setType("message/rfc822");

                //pour faire le message a envoyé
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "l'objet du message");
                intentEmail.putExtra(Intent.EXTRA_TEXT, "le corps du message");

                //declaration du destinataire
                intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{buttonEmail.getText().toString(), "mathieu.masset@vivaneo.fr"});

                //email en copie
                intentEmail.putExtra(Intent.EXTRA_CC, new String[] {"email3@vivaneo.fr", "email4@vivaneo.fr"});

                //lancement de l'activité
                startActivity(intentEmail);

            }
        });

        buttonPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pour lancer l'application telephone
                Intent intentPhone = new Intent(Intent.ACTION_DIAL);

                //on lui rajoute en parametre le "tel" + le contenu du buttonPhone avec son type
                intentPhone.setData(Uri.parse("tel:" + buttonPhone.getText().toString()));

                //lancement de l'activité
                startActivity(intentPhone);

            }
        });

        buttonUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //redirection vers une page web
                //pour lancer une application qui aura une action
                Intent intentWeb = new Intent(Intent.ACTION_VIEW);

                //une Uri est le shema d'un protocole comme le http
                intentWeb.setData(Uri.parse(buttonUrl.getText().toString()));

                //lancement de l'activité
                startActivity(intentWeb);
            }
        });
    }




}
