package com.example.bigoloo.myapplication

import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by bigoloo on 12/23/17
 */


interface RetroApi {
    @GET("api/single")
    fun searchUser(): Observable<User>

    @GET("api/multiple")
    fun getListUser(): Observable<List<User>>
}