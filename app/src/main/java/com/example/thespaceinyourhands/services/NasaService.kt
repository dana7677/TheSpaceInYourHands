package com.example.thespaceinyourhands.services
import com.example.thespaceinyourhands.data.NasaResponseMars
import com.example.thespaceinyourhands.data.NasaResponseStelar
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaService {


    @GET("planetary/apod")
    suspend fun findStellarImageOfTheDay(
        @Query("date") date: String, //Year-Month-Day
        @Query("api_key") apiKey: String = "WS14dOGy8hq3Ij9h74Ue3vwhtrstmLbd0yiOk374"
    ): NasaResponseStelar
    //https://api.nasa.gov/planetary/apod?api_key=WS14dOGy8hq3Ij9h74Ue3vwhtrstmLbd0yiOk374&date=2025-02-03

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun findMarsRoverPhotos(
        @Query("api_key") apiKey: String = "WS14dOGy8hq3Ij9h74Ue3vwhtrstmLbd0yiOk374",
        @Query("sol") date: String ,//SolDate
        @Query("camera") camera: String
        /*
        //Camera Nasa
    FHAZ	Front Hazard Avoidance Camera
    RHAZ	Rear Hazard Avoidance Camera
    MAST	Mast Camera
    CHEMCAM	Chemistry and Camera Complex
    MAHLI	Mars Hand Lens Imager
    MARDI	Mars Descent Imager
    NAVCAM	Navigation Camera
    PANCAM	Panoramic Camera
    MINITES	Miniature Thermal Emission Spectrometer (Mini-TES)
    */
    ): NasaResponseMars
    //https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=fhaz&api_key=DEMO_KEY

}