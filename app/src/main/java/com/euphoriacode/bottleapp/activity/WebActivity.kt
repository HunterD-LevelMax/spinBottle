package com.euphoriacode.bottleapp.activity

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.CookieManager
import android.widget.Toast
import com.euphoriacode.bottleapp.customclass.CustomActivity
import com.euphoriacode.bottleapp.customclass.CustomWebView
import com.euphoriacode.bottleapp.*
import com.euphoriacode.bottleapp.databinding.ActivityWebBinding

class WebActivity : CustomActivity() {
    private lateinit var binding: ActivityWebBinding
    private lateinit var url: String
    private lateinit var webView: CustomWebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        url = intent.getStringExtra("url").toString()
        webView = binding.webView
        webView.loadUrl(url)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!getInternetStatus(this)) {
                showToast(getString(R.string.internet_status_message))
                return true
            }
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
                CookieManager.getInstance().flush()
                return true
            } else {
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return false
    }

    override fun onStop() {
        getInternetStatus(this)
        CookieManager.getInstance().flush()
        super.onStop()
    }

    override fun onResume() {
        if (!getInternetStatus(this)) {
            Toast.makeText(this, getString(R.string.internet_status_message), Toast.LENGTH_SHORT)
                .show()
        }
        super.onResume()
        CookieManager.getInstance().flush()
    }
}

