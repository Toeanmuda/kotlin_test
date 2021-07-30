package com.example.test_kotlin

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MainWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        return try {
            Log.d("MAINWORKER", "WORKERRUN")
            return Result.success();
        } catch (e: Throwable) {
            Log.d("MAINWORKER", "FAILEDWORKERRUN")
            return Result.failure();
        }
    }
}