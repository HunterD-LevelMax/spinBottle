package com.euphoriacode.bottleapp.activity

import android.os.Bundle
import com.euphoriacode.bottleapp.customclass.CustomActivity
import com.euphoriacode.bottleapp.*
import com.euphoriacode.bottleapp.replaceActivity
import com.euphoriacode.bottleapp.databinding.ActivitySettingsBinding

class SettingsActivity : CustomActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageViewIds = listOf(
            binding.imageViewVine,
            binding.imageViewBear,
            binding.imageViewVine2,
            binding.imageView3,
            binding.imageView4
        )

        imageViewIds.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                id = index
                replaceActivity(BottleActivity())
                finish()
            }
        }
    }
}