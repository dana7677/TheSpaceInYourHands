package com.example.thespaceinyourhands.data

import com.google.gson.annotations.SerializedName
data class NasaResponseMars(
    @SerializedName ("photos") val results: List<Photos>

){}
data class Photos (
    @SerializedName("id") val id:Int,
    @SerializedName("sol") val sol:Int,
    @SerializedName ("camera") val results: List<Camera>,
    @SerializedName("img_src") val img_src:String,
    @SerializedName("earth_date") val earthDate:String,
    @SerializedName ("rover") val rover: List<Rover>

){}
data class Camera(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("rover_id") val roverId:Int,
    @SerializedName("full_name") val fullName:String
){}
data class Rover(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("landing_date") val landingDate:String,
    @SerializedName("launch_date") val launchDate:String,
    @SerializedName("status") val status:String
){}
