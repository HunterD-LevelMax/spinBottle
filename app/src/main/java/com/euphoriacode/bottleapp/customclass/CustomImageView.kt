package com.euphoriacode.bottleapp.customclass

import android.content.Context
import android.util.AttributeSet
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.widget.AppCompatImageView
import com.euphoriacode.bottleapp.activity.BottleActivity
import com.euphoriacode.bottleapp.activity.MainActivity
import com.euphoriacode.bottleapp.replaceActivity
import kotlin.random.Random

class CustomImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var rotating: Boolean = false
    private var previousRotation = 0f

    init {
        this.setOnClickListener {
            if (!rotating) {
                try {
                    rotateBottle()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
    private fun rotateBottleMain(activity: MainActivity) {
        val fromDegree =
            previousRotation % 360.0f // убедимся, что начальный угол не превышает 360 градусов
        val fullRotations = Random.nextInt(2, 2) // случайное количество полных оборотов
        val toDegree =
            fullRotations * 360.0f + Random.nextFloat() * 360.0f // случайный угол в пределах 360 градусов
        val centerX = this@CustomImageView.width / 2.0f
        val centerY = this@CustomImageView.height / 2.0f
        val animation: Animation = RotateAnimation(fromDegree, toDegree, centerX, centerY)
        animation.duration = 1 // время вращения бутылки в миллисекундах
        animation.fillAfter = true
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                rotating = true
                this@CustomImageView.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animation?) {
                rotating = false
                this@CustomImageView.isEnabled = true
                previousRotation = toDegree % 360.0f // сохраняем угол после вращения
                activity.replaceActivity(BottleActivity())
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        this@CustomImageView.startAnimation(animation)
    }


    private fun rotateBottle() {
        val fromDegree =
            previousRotation % 360.0f // убедимся, что начальный угол не превышает 360 градусов
        val fullRotations = Random.nextInt(5, 10) // случайное количество полных оборотов
        val toDegree =
            fullRotations * 360.0f + Random.nextFloat() * 360.0f // случайный угол в пределах 360 градусов
        val centerX = this@CustomImageView.width / 2.0f
        val centerY = this@CustomImageView.height / 2.0f
        val animation: Animation = RotateAnimation(fromDegree, toDegree, centerX, centerY)
        animation.duration = 5000 // время вращения бутылки в миллисекундах
        animation.fillAfter = true
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                rotating = true
                this@CustomImageView.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animation?) {
                rotating = false
                this@CustomImageView.isEnabled = true
                previousRotation = toDegree % 360.0f // сохраняем угол после вращения
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        this@CustomImageView.startAnimation(animation)
    }

}
