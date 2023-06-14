package com.chivumarius.movieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


// ♦ The "Movie" Data Class "Model"
//      → as an "Movie Object".

// ♦ The "@Entity" Annotation
//      → Specifies that the Class "Acts"
//      → as an "Entity", as a "Table":
@Entity(tableName = "popular_movies")
data class Movie(

    // ♦ The "@PrimaryKey" Annotation
    //      → Marks a "Field" in an "Entity"
    //      → as the "Primary Key".

    // ♦ "@SerializedName" Annotation
    //      → will look for the "id" variable
    //      → in the "JSON" File
    @PrimaryKey
    @SerializedName("id")
    val Movieid: Int,


    // ♦ The "@SerializedName" Annotation:
    @SerializedName("overview")
    val overview: String,

    // ♦ The "@SerializedName" Annotation:
    @SerializedName("poster_path")
    val poster_path: String,

    // ♦ The "@SerializedName" Annotation:
    @SerializedName("release_date")
    val releaseDate: String,

    // ♦ The "@SerializedName" Annotation:
    @SerializedName("title")
    val title: String
)