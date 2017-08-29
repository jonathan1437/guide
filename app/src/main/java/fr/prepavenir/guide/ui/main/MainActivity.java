package fr.prepavenir.guide.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import fr.prepavenir.guide.ui.home.HomeActivity;
import fr.prepavenir.guide.R;

public class MainActivity extends AppCompatActivity {

    private Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //transition vers l'écran d'acdceuil
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                // TODO: Lancer l'écran HomeActivity
                Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);

                //déclencher l'ouverture de l'activity
                startActivity(myIntent);
                finish();

            }
        }, 2000);
    }
}
