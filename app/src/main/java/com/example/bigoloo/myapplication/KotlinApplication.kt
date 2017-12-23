package com.example.bigoloo.myapplication

import android.app.Application
import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by bigoloo on 12/23/17
 */
class KotlinApplication : Application() {


    companion object {
        val retroApi: Retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.3.2:4040/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()




    }

    override fun onCreate() {
        super.onCreate()
        Log.d("aaaaa", "Asdasdasdasd")


    }

}