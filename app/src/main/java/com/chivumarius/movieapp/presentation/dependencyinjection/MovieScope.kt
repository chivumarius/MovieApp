package com.chivumarius.movieapp.presentation.dependencyinjection

import javax.inject.Scope


// ♦ This Class → is used to "Provide Us"
//      → just an "Annotation".
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)  // ♦ The ".Retention()" → is Used in order to "Annotating" during "Runtime".
annotation class MovieScope {
}