package com.example.bigoloo.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {


    val helloWorld by lazy { findViewById(R.id.hello_world) as TextView }

    val recycleView by lazy { findViewById(R.id.recyclerView) as RecyclerView }
    val adapter = RecycleViewAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var retroApi = KotlinApplication.retroApi.create(RetroApi::class.java)
        val layoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManager
        var observableUser = retroApi.searchUser()
        observableUser.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user: User ->
                    Log.d("kotikoti", "user description ${user.description}")
                    helloWorld.text = user.description
                }, {
                    e ->
                    Log.e("kotikoti", "something goes wrong", e)
                }
                )
        var observableListUser = retroApi.getListUser()
        observableListUser.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    userList: List<User> ->
                    Log.d("kotikoti", "user description ${userList}")

                    adapter.addAll(userList)
                    recycleView.adapter = adapter
                    adapter.notifyDataSetChanged()
                }, { e -> Log.e("kotikoti", "recycleView Application ", e) })


    }
}
