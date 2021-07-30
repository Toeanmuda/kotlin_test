package com.example.test_kotlin

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.test_kotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val uploadworkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<MainWorker>().build()

        WorkManager.getInstance(this)
            .enqueue(uploadworkRequest)


        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uploadworkRequest.id)
            .observe(this, Observer { info ->
                if (info != null && info.state.isFinished) {
                    Toast.makeText(this, "WORKER RUNNING", Toast.LENGTH_LONG).show();
                }
            })


    }
}