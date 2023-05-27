package com.euphoriacode.bottleapp.activity

import android.os.Bundle
import com.euphoriacode.bottleapp.*
import com.euphoriacode.bottleapp.customclass.CustomActivity
import com.euphoriacode.bottleapp.databinding.ActivityMainBinding

class MainActivity : CustomActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        with(binding) {

            buttonGame.setOnClickListener {
                replaceActivity(BottleActivity())
            }

            buttonSettings.setOnClickListener {
                replaceActivity(SettingsActivity())
            }
        }
    }
}
