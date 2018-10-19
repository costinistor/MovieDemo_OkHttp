package com.moviedemo_okhttp.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviedemo_okhttp.activity.MovieActivity
import com.moviedemo_okhttp.models.Movie
import com.moviedemo_okhttp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_movie_item.view.*

/**
 * Created by Costi on 10/17/2018.
 */
class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    val movies = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
        return MovieViewHolder(view.inflate(R.layout.row_movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindModel(movies[position])
        holder.onClick(position)
    }

    fun setMovies(data: List<Movie>) {
        movies.addAll(data)
        notifyDataSetChanged()
    }

    class MovieViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bindModel(movie: Movie){
            view.tvMovieTitle.text = movie.title
            view.tvMovieGenre.text = movie.genre
            view.tvMovieYear.text = movie.year
            Picasso.get().load(movie.poster).into(view.imgMovie)

            //view.setOnClickListener { println("Push dot") }
        }

        fun onClick(position: Int){
            view.setOnClickListener {
                println("Push dot at $position")
                val intent = Intent(view.context, MovieActivity::class.java)
                view.context.startActivity(intent)
            }

        }
    }
}

