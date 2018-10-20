package com.moviedemo_okhttp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.moviedemo_okhttp.adapters.MovieAdapter
import com.moviedemo_okhttp.FetchMovie
import com.moviedemo_okhttp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var movieAdapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieAdapter = MovieAdapter()
        movie_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        movie_list.layoutManager = LinearLayoutManager(this)
        movie_list.adapter = movieAdapter

        val fet = FetchMovie()
        fet.fetchJsonMovie(movieAdapter, this)

    }

//    fun fetchJsonMovie(){
//        val url = "https://raw.githubusercontent.com/filippella/Sample-API-Files/master/json/movies-api.json"
//        val request = Request.Builder().url(url).build()
//
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object: Callback{
//            override fun onFailure(call: Call?, e: IOException?) {
//                println("Failed to download json")
//            }
//
//            override fun onResponse(call: Call?, response: Response?) {
//                val body = response?.body()?.string()
//                val gson = GsonBuilder().create()
//                val movies = gson.fromJson(body, MovieResponse::class.java)
//                runOnUiThread {
//                    movieAdapter.setMovies(movies.data)
//                }
//            }
//        })
//    }
}
