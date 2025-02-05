package com.example.thespaceinyourhands

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thespaceinyourhands.data.NasaResponseMars
import com.example.thespaceinyourhands.data.NasaResponseStelar
import com.example.thespaceinyourhands.databinding.ActivityMainBinding
import com.example.thespaceinyourhands.retrofit.RetrofitProvider
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var NasaResponse:NasaResponseStelar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()

        GetStellarImgToday("2025-02-03")
    }

    private fun GetStellarImgToday(query: String) {
        val service = RetrofitProvider.getRetrofit()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = service.findStellarImageOfTheDay(query)

                CoroutineScope(Dispatchers.Main).launch {

                    if (result.title!="") {

                        NasaResponse = result
                        Picasso.get().load(result.url).into(binding.ImgStellar)
                        binding.TxtAutor.text = result.title;
                        binding.TxtBiography.text = result.copyright;

                    } else {
                       //No Results
                    }
                }
            } catch (e: Exception) {
                Log.e("API", e.stackTraceToString())

                CoroutineScope(Dispatchers.Main).launch {
                   //No Results
                }
            }
        }
    }
}