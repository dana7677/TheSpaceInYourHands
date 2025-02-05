package com.example.thespaceinyourhands.data

import com.google.gson.annotations.SerializedName

data class NasaResponseStelar (
    //@SerializedName ("response") val response: String, // Añadido mio
    @SerializedName("copyright") val copyright: String,
    @SerializedName("date") val date: String,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("media_type") val mediaType: String,
    @SerializedName("service_version") val serviceVersion: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String
) { }