package com.movies.allmovies.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movies.allmovies.AppConstants
import com.movies.allmovies.R
import com.movies.allmovies.domainmodel.DomainMovie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MoviesAdapter (val context: Context?, val movies: Collection<DomainMovie>) :
    RecyclerView.Adapter<MoviesAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        Picasso.get()
            .load("${AppConstants.TMDB_IMAGE_BASE_URL_W185}${movies.elementAt(position).poster_path}")
            .placeholder(R.drawable.placeholder)
            .into(holder.poster)

    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView = itemView.cv_movie
        var poster = itemView.iv_movie_poster
    }

}