package com.chivumarius.movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chivumarius.movieapp.data.model.Movie


// ♦ We "Annotate" the "Class"
//      → as "@Database"
//      → with the "Tables"/"Entities" it "Has":

// ♦ We "Specify" the "TMDBDatabase" Abstract Class
//      → to "Act" as a "Database"
//      → by Extending "RoomDatabase" Class:
@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){

    // ♦ The " movieDao()" Method
    //      → will Return "MovieDao" Object:
    abstract fun movieDao() : MovieDao
}