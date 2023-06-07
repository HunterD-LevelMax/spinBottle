package com.euphoriacode.bottleapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("UseCompatLoadingForDrawables")

var id = R.drawable.asset_1

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity, url: String) {
    val intent = Intent(this, activity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
    intent.putExtra("url", url)
    startActivity(intent)
    // this.finish()
}

fun getInternetStatus(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}