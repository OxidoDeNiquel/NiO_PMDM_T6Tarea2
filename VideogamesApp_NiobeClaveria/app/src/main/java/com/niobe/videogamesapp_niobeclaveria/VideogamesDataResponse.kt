package com.niobe.videogamesapp_niobeclaveria

import com.google.gson.annotations.SerializedName

data class VideogamesDataResponse(
    @SerializedName("results") val videogames: List<VideogamesItemResponse>
)

data class VideogamesItemResponse(
    @SerializedName("name") val name: String,
    @SerializedName("background_image") val imageVG: String,
    @SerializedName("rating") val ratingVG: String,
    @SerializedName("released") val releasedVG: String,
    @SerializedName("platforms") val platformsVG: List<VideogamesPlataformsResponse>,
    @SerializedName("genres") val genresVG: List<VideogamesGenresResponse>
)
data class VideogamesPlataformsResponse(
    @SerializedName("platform") val platformVG: VideogamesPlataformsNameResponse
)
data class VideogamesPlataformsNameResponse(
    @SerializedName("name") val platformName: String
)
data class VideogamesGenresResponse(
    @SerializedName("name") val genreName: String
)