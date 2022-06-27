package com.example.movieapplication.data.modal.artist


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>,

    )