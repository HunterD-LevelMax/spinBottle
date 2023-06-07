package com.euphoriacode.bottleapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.euphoriacode.bottleapp.databinding.ImageItemBinding

class ImageAdapter(private val data: ArrayList<BottleImage>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(), View.OnClickListener {

    var imageActionListener: ImageActionListener? = null

    interface ImageActionListener {
        fun onImageClicked(imageId: Int)
    }

    class ImageViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ImageItemBinding.inflate(inflater, parent, false)
        binding.imageView.setOnClickListener(this)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = data[position]
        with(holder.binding) {
            imageView.setImageResource(image.id)
            imageView.tag = image // Установка значения тега для ImageView
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onClick(view: View?) {
        val bottleImage: BottleImage? = view?.tag as? BottleImage
        bottleImage?.let {
            val position = data.indexOfFirst { it.id == bottleImage.id }
            val selectedImageId = data[position].id
            imageActionListener?.onImageClicked(selectedImageId)
        }
    }
}