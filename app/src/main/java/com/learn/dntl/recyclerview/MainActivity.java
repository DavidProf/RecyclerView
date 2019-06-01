package com.learn.dntl.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    //ButterKnife implemented build.gradle, recycler_view in activity_main
    //RecyclerView implemented in build.gradle
    @BindView(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);//ButterKnife implemented build.gradle

        RocketModel rocketModel = new RocketModel("Falcon1", "24/12/2018", true, "Succeeded");
        RocketModel rocketModel2 = new RocketModel("Falcon2", "24/01/2019", true, "Succeeded");
        RocketModel rocketModel3 = new RocketModel("Falcon3", "24/01/2019", true, "Succeeded");

        ArrayList<RocketModel> rocketModels = new ArrayList<>();
        rocketModels.add(rocketModel);
        rocketModels.add(rocketModel2);
        rocketModels.add(rocketModel3);

        RecyclerAdapter adapter = new RecyclerAdapter(rocketModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        spinnerImpl();
    }

    private void spinnerImpl() {

        String[] stringList = {"a", "b", "c", "d", "e", "f"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stringList);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = adapter1.getItem(position);

                //Toast - show message in the window (position bottom)
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_LONG).show();//LENGTH_SHORT OR LENGTH_LONG

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
