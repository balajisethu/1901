package com.bseth.a1901_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by bseth on 19-01-2017.
 */

public class ShowMovieDetails extends AppCompatActivity {
    private TextView id;
    private TextView title;
    private TextView description;
    private TextView author_name;

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movie_details);

        id=(TextView) findViewById(R.id.textView1);
        title=(TextView) findViewById(R.id.textView2);
        description=(TextView) findViewById(R.id.textView3);
        author_name=(TextView) findViewById(R.id.textView4);

        Intent intent =getIntent();

        id.setText(String.valueOf(intent.getIntExtra(MainActivity.id,0)));
        title.setText(intent.getStringExtra(MainActivity.title));
        description.setText(intent.getStringExtra(MainActivity.description));
        author_name.setText(intent.getStringExtra(MainActivity.author_name));



    }
}
