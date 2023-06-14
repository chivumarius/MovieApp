package com.chivumarius.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chivumarius.movieapp.R
import com.chivumarius.movieapp.databinding.ActivityMainBinding
import com.chivumarius.movieapp.presentation.adapter.MovieAdapter
import com.chivumarius.movieapp.presentation.dependencyinjection.Injector
import com.chivumarius.movieapp.presentation.viewmodel.MyViewModel
import com.chivumarius.movieapp.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    // ♦ Variable Declaration
    @Inject    // ♦ "Field Injection"
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter


    // ♦ The "onCreate()" Method:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // ♦ Specifying the "layout":
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // ♦ Casting the "application" as "Injector":
        (application as Injector).createMovieSubComponent().inject(this)

        // ♦ Variable Initialization:
        movieViewModel = ViewModelProvider(this,factory)
            .get(MyViewModel::class.java)

        // ♦ Calling the "Method":
        initRecyclerView()
    }


    // ♦ The "initRecyclerView()" Method:
    private fun initRecyclerView() {
        // ♦ Setting "layoutManager" as "LinearLayoutManager":
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // ♦ Creating an "adapter" Instance:
        adapter = MovieAdapter()

        // ♦ Binding "adapter":
        binding.recyclerView.adapter = adapter

        // ♦  Calling the "Method":
        displayPopularMovies()
    }


    // ♦ The "displayPopularMovies()" Method:
    private fun displayPopularMovies() {
        // ♦ "Displaying" the "Movie Progress Bar":
        binding.movieProgressBar.visibility = View.VISIBLE

        // ♦ Getting tge "Movies":
        val responseLiveData = movieViewModel.getMovies()

        // ♦ "Observer":
        responseLiveData.observe(this, Observer{
            // ♦ Checking: If Item is not Empty:
            if (it != null){
                // ♦ Setting the "List" of "Adapter":
                adapter.setList(it)

                // ♦ "Notifying" that the "List" have been "Changed":
                adapter.notifyDataSetChanged()

                // ♦ Hiding the "Progress Bar":
                binding.movieProgressBar.visibility = View.GONE
            } else {
                // ♦ If there is no Response → Remove the "Progress Bar":
                binding.movieProgressBar.visibility = View.GONE

                // ♦ Displaying "Toast Message":
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }


    // ♦ The "onCreateOptionsMenu()" Method:
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // ♦  Setting the "inflater":
        val inflater: MenuInflater = menuInflater

        // ♦ Displaying "update" Menu:
        inflater.inflate(R.menu.update, menu)
        return true
    }


    // ♦ The "onOptionsItemSelected()" Method:
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // ♦ The "When"/"Switch" Case:
        return when (item.itemId) {
            R.id.action_update -> {
                // ♦ Calling the Method:
                updateMovies()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }


    // ♦ The "updateMovies()" Method:
    private fun updateMovies() {
        // ♦ "Displaying" the "Movie Progress Bar":
        binding.movieProgressBar.visibility = View.VISIBLE

        // ♦ Getting the "Update Movies":
        val response = movieViewModel.updateMovies()

        // ♦ "Observer":
        response.observe(this, Observer {
            // ♦ Checking: If "Item" is not Empty:
            if (it != null){
                // ♦ Setting the "List" of "Adapter":
                adapter.setList(it)

                // ♦ "Notifying" that the "List" have been "Changed":
                adapter.notifyDataSetChanged()

                // ♦ "Hiding" the "Progress Bar":
                binding.movieProgressBar.visibility = View.GONE
            } else {
                // ♦ If there is no Response → Remove the "Movie Progress Bar":
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }
}