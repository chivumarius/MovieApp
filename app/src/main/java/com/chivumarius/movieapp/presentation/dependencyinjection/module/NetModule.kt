package com.chivumarius.movieapp.presentation.dependencyinjection.module

import com.chivumarius.movieapp.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// ♦ The "DatabaseModule" Class
//      → will Provide us
//      → with the "Retrofit Instance".
// ♦ "Annotation" to "Act" as a "Module" for the "Class":
@Module
class NetModule(private val baseUrl: String) {


    @Singleton  // ♦ This "Annotation" → is Used for "Only One Instance" → of "Retrofit"
    // The "@Provides" Annotation
    //      → provides us with an "Instance"
    //      → of the "Retrofit Instance":
    @Provides  // ♦ This "Annotation" →  "Provides" us the "Retrofit Instance".
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }


    // ♦ Providing the "providesTMDBService" Instance:
    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}