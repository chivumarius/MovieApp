package com.chivumarius.movieapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chivumarius.movieapp.R
import com.chivumarius.movieapp.data.model.Movie
import com.chivumarius.movieapp.databinding.ListItemBinding




// ♦
class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    // ♦ Creating an "ArrayList" of "Movie" Type:
    private val movieList = ArrayList<Movie>()

    // ♦  The "setList()" Method:
    fun setList(movies: List<Movie>){
        // ♦ "Clearing" the "Movie List":
        movieList.clear()
       // ♦ Adding "All Movies" to "Movie List":
        movieList.addAll(movies)
    }



    // ♦  The "onCreateViewHolder()" Method:
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // ♦ "Initializing" the "RecyclerView":
        val layoutInflater = LayoutInflater.from(parent.context)

        // (D-B) "Initialize" the "binding" Object
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }


    // ♦  The "onBindViewHolder()" Method:
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }


    // ♦  The "getItemCount()" Method
    //      → which "Returns" the "Size" of the "Movie List":
    override fun getItemCount(): Int {
        return movieList.size
    }


    // ♦ The "MyViewHolder" Inner Class:
    class MyViewHolder(val binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root){

        // ♦ The "bind()" Method
        //      → for "Binding" all the "Widgets"
        //      → with "Object" of "Movie" Type:
        fun bind(movie:Movie){
            binding.titleTextView.text = movie.title
            binding.descTextView.text  = movie.overview

            // ♦ Getting the "Movies Image" in the "posterURL" for:
            val posterURL = "https://image.tmdb.org/t/p/w500/"+movie.poster_path

            // ♦ Using the "Glide" Library
            //      → in order to Display "Images" Faster:
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }
}