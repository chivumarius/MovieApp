package com.chivumarius.movieapp.data.model

import com.google.gson.annotations.SerializedName

// ♦ The "MovieList" Data Class "Model"
//      → as an "Movie Array":
data class MovieList(

    // ♦ "@SerializedName" Annotation
    //      → will look for the "results" Variable
    //      → in the "JSON" File.
    @SerializedName("results")
    val movies: List<Movie>
)
