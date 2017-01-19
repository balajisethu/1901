package com.bseth.a1901_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.VERSION_CODES.M;


public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    public static final String ROOT_URL="http://www.pointblank.news/getPostCat?category=1&take=4&skip=0";

    public static final String id="id";
    public static final String title="title";
    public static final String description="description";
    public static final String author_name="author_name";

    private ListView listView;

    private List<Movie> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listViewMovies);

        getMovies();

        listView.setOnItemClickListener(this);
    }
    private void getMovies()
    {
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please Wait....",false,false);

        RestAdapter adapter =new RestAdapter.Builder()
        .setEndpoint(ROOT_URL)
            .build();

        MoviesAPI api=adapter.create(MoviesAPI.class);

        api.getMovies(new Callback<List<Movie>>()
        {
            public void success(List<Movie> list, Response response) {
                loading.dismiss();

                movies = list;

                showList();
            }


        });

        }

    private void showList()
    {
        String[] items = new String[movies.size()];

        for (int i=0;i<movies.size();i++)
        {
            items[i]=movies.get(i).getTitle();
        }

        ArrayAdapter adapter= new ArrayAdapter<String>(this,R.layout.simple_list,items);

        listView.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Intent intent = new Intent(this,ShowMovieDetails.class);

        Movie movie =movies.get(position);

        intent.putExtra(id, movie.getId());
        intent.putExtra(title, movie.getTitle());
        intent.putExtra(description, movie.getDescription());
        intent.putExtra(author_name, movie.getAuthor_name() );

        startActivity(intent);

    }

}
