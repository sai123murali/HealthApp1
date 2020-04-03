package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView dietplan,alarm,steps,fitness,macros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dietplan=(CardView) findViewById(R.id.diet_control);
        alarm=(CardView) findViewById(R.id.alarm);
        steps=(CardView) findViewById(R.id.steps);
        fitness=(CardView) findViewById(R.id.fitness);
        macros=(CardView) findViewById(R.id.macros_setup);

        dietplan.setOnClickListener(this);
        alarm.setOnClickListener(this);
        steps.setOnClickListener(this);
        fitness.setOnClickListener(this);
        macros.setOnClickListener(this);
    }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId()){
            case R.id.diet_control: i=new Intent(this,diet.class);startActivity(i); break;
            case R.id.alarm: i=new Intent(this,alarm.class);startActivity(i); break;
            case R.id.steps: i=new Intent(this,steps.class);startActivity(i); break;
            case R.id.fitness: i=new Intent(this,fitness.class);startActivity(i); break;
            case R.id.macros_setup: i=new Intent(this,macros.class);startActivity(i); break;
            default: break;

        }

    }
}
