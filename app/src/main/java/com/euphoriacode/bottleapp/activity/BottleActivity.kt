package com.euphoriacode.bottleapp.activity

import android.os.Bundle
import com.euphoriacode.bottleapp.*
import com.euphoriacode.bottleapp.customclass.*
import com.euphoriacode.bottleapp.databinding.ActivityGameBinding

class BottleActivity : CustomActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var bottle: CustomImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottle = binding.bottleImage
        loadId()
    }

    private fun loadId() {
        bottle.setImageResource(id)
    }
}