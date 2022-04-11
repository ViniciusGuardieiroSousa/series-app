package br.com.vinicius.guardieiro.sousa.commons.presentation.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget

object ImageDownloader {
    fun downloadImage(context: Context, imageUrl : String, resourceReady : (Bitmap) -> Unit) {
        Glide.with(context)
            .asBitmap()
            .load(imageUrl)
            .into(object : CustomTarget<Bitmap>(){
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                ) {
                    resourceReady.invoke(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {

                }

            })
    }
}