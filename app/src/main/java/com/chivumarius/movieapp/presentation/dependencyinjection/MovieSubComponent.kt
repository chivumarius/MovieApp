package com.chivumarius.movieapp.presentation.dependencyinjection

import com.chivumarius.movieapp.presentation.MainActivity
import com.chivumarius.movieapp.presentation.dependencyinjection.module.MovieModule
import dagger.Subcomponent


// ♦ This "Interface" → is "Used" as a "Template".
@MovieScope
@Subcomponent(modules = [MovieModule::class])   // ♦ This "Inherits Bindings" from a "Parent Component" or "Subcomponent". .
interface MovieSubComponent {
    // ♦ The "inject()" Function:
    fun inject(movieActivity: MainActivity)

    // ♦ Creating the "Factory" Interface:
    @Subcomponent.Factory
    interface Factory{
        // ♦ The "create()" Function:
        fun create(): MovieSubComponent
    }
}