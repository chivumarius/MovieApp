package com.chivumarius.movieapp.presentation.dependencyinjection.module

import android.content.Context
import com.chivumarius.movieapp.presentation.dependencyinjection.MovieSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



// ♦ This Class → will "Provide Us"
//      → the "applicationContext".
@Module(subcomponents = [MovieSubComponent::class])    // ♦ "Annotation" → to "Act" as a "Module" for the "Class".
class AppModule (private val context: Context){

    @Singleton   // ♦ This "Annotation"  → is Used for "Only One Instance"  → of "applicationContext"
    @Provides   // ♦ This "Annotation" → Provides us the "applicationContext".
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}