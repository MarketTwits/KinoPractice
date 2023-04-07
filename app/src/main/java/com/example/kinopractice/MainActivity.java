package com.example.kinopractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.kinopractice.presentation.search_films.SearchFilmsActivity;
import com.example.kinopractice.presentation.search_theters.SearchTheatersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // добавляем пункты меню
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent intent =null;
        switch (item.getItemId())
        {
            case R.id.m1: intent = new Intent(this, SearchTheatersActivity.class);
                break;
            case R.id.m2: intent = new Intent(this, SearchFilmsActivity.class);
                break;
            case R.id.m3: intent = new Intent(this, newtheatre.class);
                break;
            case R.id.m4: intent = new Intent(this, newfilm.class);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    public void onClickTheater(View view){
        Intent intent;
        intent = new Intent(this, SearchTheatersActivity.class);
        startActivity(intent);
    }
    public void onClickFilms(View view){
        Intent intent;
        intent = new Intent(this, SearchFilmsActivity.class);
        startActivity(intent);
    }
    public void onClickNewTheater(View view){
        Intent intent;
        intent = new Intent(this, newtheatre.class);
        startActivity(intent);
    }
    public void onClickNewFilms(View view){
        Intent intent;
        intent = new Intent(this, newfilm.class);
        startActivity(intent);
    }
}