package com.euphoriacode.bottleapp.activity

import android.os.Bundle
import com.euphoriacode.bottleapp.*
import com.euphoriacode.bottleapp.customclass.CustomActivity
import com.euphoriacode.bottleapp.databinding.ActivityMainBinding
import com.euphoriacode.bottleapp.getInternetStatus
import com.euphoriacode.bottleapp.replaceActivity

class MainActivity : CustomActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGame.setOnClickListener {
            replaceActivity(BottleActivity())
        }

        binding.buttonAbout.setOnClickListener {
            if (getInternetStatus(this@MainActivity)) {
                replaceActivity(WebActivity(), URL_ABOUT)
            } else {
                showToast(getString(R.string.internet_status_message))
            }
        }

        binding.buttonSettings.setOnClickListener {
            replaceActivity(SettingsActivity())
        }
    }

}