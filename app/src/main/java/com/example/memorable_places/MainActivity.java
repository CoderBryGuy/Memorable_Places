package com.example.memorable_places;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    List<Location> locations;
    List<String> location_addresses;
    ArrayAdapter<String> myAdapter;
    String addNewPlace = "Add a new place...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locations = new ArrayList<>();
        location_addresses = new ArrayList<>();
        location_addresses.add(addNewPlace);

        myListView = (ListView)findViewById(R.id.myListView);

        myAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, location_addresses);

        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(location_addresses.size() == 1 && location_addresses.get(i).equals(addNewPlace)){
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    intent.putExtra("USE_CURRENT_LOCATION", true);
                    startActivity(intent);
                }
            }
        });


    }
}