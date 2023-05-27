package com.euphoriacode.bottleapp.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.euphoriacode.bottleapp.*
import com.euphoriacode.bottleapp.adapter.Image
import com.euphoriacode.bottleapp.adapter.ImageAdapter
import com.euphoriacode.bottleapp.customclass.CustomActivity
import com.euphoriacode.bottleapp.databinding.ActivitySettingsBinding

class SettingsActivity : CustomActivity(), ImageAdapter.ImageActionListener {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var adapter: ImageAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ImageAdapter(setData())
        adapter.imageActionListener = this

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this@SettingsActivity)
        recyclerView.adapter = adapter
    }

    private fun setData(): ArrayList<Image> {
        val images = arrayOf(
            R.drawable.asset_1,
            R.drawable.asset_2,
            R.drawable.asset_3,
            R.drawable.asset_4,
            R.drawable.asset_5
        )

        val imageList = ArrayList<Image>()

        for (element in images) {
            imageList.add(Image(element))
        }
        return imageList
    }

    override fun onImageClicked(imageId: Int) {
        id = imageId
        replaceActivity(BottleActivity())
        this.finish()
    }
}
