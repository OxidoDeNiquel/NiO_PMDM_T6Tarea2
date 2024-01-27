package com.niobe.videogamesapp_niobeclaveria

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("api/games?key=050672a508654fc9a316f271ca6e5184")
    suspend fun getVideogames(@Query("search") vgName:String): Response<VideogamesDataResponse>
}