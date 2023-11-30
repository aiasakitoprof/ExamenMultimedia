package com.example.examenmultimedia;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class HorizontalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_activity); // Asegúrate de que este es el nombre correcto del layout

        System.out.println("Existo");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewh1, ListFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();


        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewh2, BlankFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}