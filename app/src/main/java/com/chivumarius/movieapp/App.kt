package com.chivumarius.movieapp

import android.app.Application
import com.chivumarius.movieapp.presentation.dependencyinjection.AppComponent
import com.chivumarius.movieapp.presentation.dependencyinjection.DaggerAppComponent
import com.chivumarius.movieapp.presentation.dependencyinjection.Injector
import com.chivumarius.movieapp.presentation.dependencyinjection.MovieSubComponent
import com.chivumarius.movieapp.presentation.dependencyinjection.module.AppModule
import com.chivumarius.movieapp.presentation.dependencyinjection.module.NetModule
import com.chivumarius.movieapp.presentation.dependencyinjection.module.RemoteDataModule


class App: Application(), Injector {
    // ♦ Variable Declaration:
    private lateinit var appComponent: AppComponent

    // ♦ The "onCreate()" Method:
    override fun onCreate() {
        super.onCreate()

        // ♦ Specifying to "Dagger"
        //      → to "Inject" the "Modules":
        //      → "appModule", "netModule", "remoteDataModule":
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }


    // ♦ The "createMovieSubComponent()" Method:
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}