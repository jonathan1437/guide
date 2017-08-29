package fr.prepavenir.guide.ui.listing;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.prepavenir.guide.R;
import fr.prepavenir.guide.models.Restaurant;


public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    private int resId;
    private LayoutInflater inflater; //par default = null

    //pour la création du constructeur il faut faire alt entrer en cliquant sur le nom de la class
    public RestaurantAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);

        resId = resource; //récupération du layout R.layout.item_restaurant
        inflater = LayoutInflater.from(context);//permet d'afficher le layout item_restaurant
    }

    @NonNull
    @Override
    //methode fesant parti de arrayAdapter
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)


    {
        ViewHolder myViewHolder; //declaration
        //affichage du layout item_restaurant
        //a la base la ligne est vide donc on lui dit que si la ligne est vide alors tu met le layout resiId
        if (convertView == null) {
            convertView = inflater.inflate(resId, null); //permet d'afficher le layout item_restaurant

            myViewHolder = new ViewHolder(); //instance de classe

            myViewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
            myViewHolder.textViewCategory = (TextView) convertView.findViewById(R.id.textViewCategory);

            //recuprerer le titre
            TextView textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
            TextView textViewCategory = (TextView) convertView.findViewById(R.id.textViewCategory);

            convertView.setTag(myViewHolder);//enregistrer les propriétés title et category
        } else {
            myViewHolder = (ViewHolder) convertView.getTag(); //recuperation des propriétés
        }
        //recuperation d'un objet Restaurant par rapport à la position
        Restaurant item = getItem(position);

        //affichage des informations du Restaurant
        myViewHolder.textViewTitle.setText(item.getName());
        myViewHolder.textViewCategory.setText(item.getCategory());


        return convertView;
    }

    //permet de mettre a jours le contenu dynamiquement
    class ViewHolder {
        TextView textViewTitle;
        TextView textViewCategory;
    }
}
