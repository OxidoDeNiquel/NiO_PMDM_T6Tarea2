package com.niobe.videogamesapp_niobeclaveria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.niobe.videogamesapp_niobeclaveria.databinding.ActivityVideogamesListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideogamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideogamesListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: VideogamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //cambiamos la forma de acceder al layout
        binding = ActivityVideogamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()

        initUI()
    }
    private fun initUI() {
        binding.searchViewVg.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?) = false

        })
        adapter = VideogamesAdapter()
        binding.rvVideogames.setHasFixedSize(true)
        binding.rvVideogames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvVideogames.adapter = adapter

    }

    private fun searchByName(query: String) {
        binding.progressBarVg.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<VideogamesDataResponse> =
                retrofit.create(ApiService::class.java).getVideogames(query)
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
                val response: VideogamesDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.videogames)
                        binding.progressBarVg.isVisible = false
                    }

                }

            } else {
                Log.i("Consulta", "No funciona :(")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.rawg.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}