package com.example.dell.movieexplorationsystem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Dell on 3/4/2017.
 */
public class Children extends Activity {

    ArrayList<Movie> childrenMovies ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionpage);
        childrenMovies = new ArrayList<>();
        ListView listView =(ListView) findViewById(R.id.movielist);

        InputStream is = this.getResources().openRawResource(
                R.raw.output4);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try{
            String str;
            while((str = reader.readLine())!=null) {
                String[] tokens = str.split(" ");
                long movieId = Long.parseLong(tokens[0]);
                float rating = Float.parseFloat(tokens[1]);
                childrenMovies.add(new Movie(movieId,rating));
            }

        }
        catch (IOException e){

        }
        CustomAdapter customAdapter = new CustomAdapter(childrenMovies,Children.this);
        listView.setAdapter(customAdapter);
    }
}
