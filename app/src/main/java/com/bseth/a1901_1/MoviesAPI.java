package com.bseth.a1901_1;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by bseth on 19-01-2017.
 */

public class MoviesAPI
{
    @GET("http://www.pointblank.news/getPostCat?category=1&take=4&skip=0")
    public void getMovies(Callback<List<Movie>> response) {

    }
}
