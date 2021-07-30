package com.example.test_kotlin

import android.app.Application
import androidx.work.*
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
/*
        val constraints = Constraints.Builder()
*/
/*
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
*//*

            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()


        val uploadworkRequest =
            PeriodicWorkRequestBuilder<MainWorker>(15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()
*/

       /* WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(
                "MARTA",
                ExistingPeriodicWorkPolicy.KEEP, uploadworkRequest
            )*/
    }
}