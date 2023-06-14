package com.chivumarius.movieapp.presentation.dependencyinjection

import com.chivumarius.movieapp.presentation.dependencyinjection.module.*
import dagger.Component
import javax.inject.Singleton

// ♦ In this "Interface"
//      → we Specify "All" the "Modules" of the "Application".
@Singleton  // ♦ This "Annotation"  → is Used for "Only One Instance"  → of ""
@Component( modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
])
interface AppComponent {
    // ♦ The Function:
    fun movieSubComponent(): MovieSubComponent.Factory
}