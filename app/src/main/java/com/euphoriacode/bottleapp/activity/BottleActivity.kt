package com.euphoriacode.bottleapp.activity

import android.os.Bundle
import com.euphoriacode.bottleapp.R
import com.euphoriacode.bottleapp.customclass.CustomActivity
import com.euphoriacode.bottleapp.customclass.CustomImageView
import com.euphoriacode.bottleapp.databinding.ActivityGameBinding
import com.euphoriacode.bottleapp.id

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
        val images = arrayOf(
            R.drawable.asset_1,
            R.drawable.asset_2,
            R.drawable.asset_3,
            R.drawable.asset_4,
            R.drawable.asset_5
        )
        val drawableId = images[id]
        bottle.setImageResource(drawableId)
    }
}