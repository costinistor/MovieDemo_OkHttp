package com.moviedemo_okhttp

import android.app.Activity
import com.google.gson.GsonBuilder
import com.moviedemo_okhttp.adapters.MovieAdapter
import com.moviedemo_okhttp.models.MoviesList
import okhttp3.*
import java.io.IOException

class FetchMovie {
    fun fetchJsonMovie(movieAdapter: MovieAdapter, activity: Activity){
        val url = "https://raw.githubusercontent.com/costinistor/Sample-API-JSON/master/json/movies-api.json"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to download json")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()
                val movies = gson.fromJson(body, MoviesList::class.java)
                activity.runOnUiThread {
                    movieAdapter.setMovies(movies.data)
                }
            }

        })
    }
}