package com.annecodes.debuggingwithstetho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.annecodes.debuggingwithstetho.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGet.setOnClickListener {
            binding.progressBar.isVisible = true
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    val result = DogsApi.dogsApi.getRandomDog()

                    binding.progressBar.isVisible = false

                    Glide
                        .with(binding.dogImageView)
                        .load(result.message)
                        .placeholder(R.drawable.image_placeholder)
                        .into(binding.dogImageView)

                } catch (e: Exception) {
                    binding.progressBar.isVisible = false
                }
            }
        }
    }
}