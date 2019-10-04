package com.lacourt.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.lacourt.myapplication.model.Movie
import com.lacourt.myapplication.repository.HomeRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private var homeRepository: HomeRepository? = null
    var movies: LiveData<PagedList<Movie>>? = null

    init {
        homeRepository = HomeRepository(application)
        movies = homeRepository?.movies
    }

    fun rearrengeMovies(order: String) {
        homeRepository?.rearrengeMovies(order)
    }
}