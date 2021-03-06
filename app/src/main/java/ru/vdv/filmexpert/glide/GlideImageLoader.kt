package ru.vdv.myapp.myreadersdiary.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import ru.vdv.filmexpert.R

class GlideImageLoader : ImageLoader<ImageView> {
    override fun loadMovieCover(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .placeholder(R.drawable.zgl)
            .error(R.drawable.zgl)
            .transition(DrawableTransitionOptions.withCrossFade(1500))
            .centerCrop()
            .into(container)
    }

    override fun loadActorAvatar(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .placeholder(R.drawable.zgl_actor)
            .error(R.drawable.zgl_actor)
            .transition(DrawableTransitionOptions.withCrossFade(1500))
            .centerCrop()
            .into(container)
    }

    override fun loadMovieBackground(url: String, container: ImageView) {
        val options = RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        Glide.with(container.context)
            .load(url)
            .placeholder(R.drawable.bg1_01_2)
            //.error(R.drawable.error_sign)
            .transition(DrawableTransitionOptions.withCrossFade(1500))
            .apply(options)
            .centerCrop()
            .into(container)
    }
}