package com.chivumarius.movieapp.presentation.dependencyinjection



// ♦ This "Interface"
//      → wil "Return" the "MovieSubComponent".
interface Injector {
    // ♦ The  "createMovieSubComponent()" Function:
    fun createMovieSubComponent(): MovieSubComponent
}