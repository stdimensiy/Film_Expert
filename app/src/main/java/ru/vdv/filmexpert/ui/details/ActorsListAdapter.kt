package ru.vdv.filmexpert.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.filmexpert.domain.Actor
import ru.vdv.filmexpert.model.api.TmdbApiConstants
import ru.vdv.myapp.myreadersdiary.glide.GlideImageLoader
import ru.vdv.myapp.myreadersdiary.glide.ImageLoader

class ActorsListAdapter : RecyclerView.Adapter<ActorsListViewHolder>() {
    private val imageLoader: ImageLoader<ImageView> = GlideImageLoader()
    var items: List<Actor> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsListViewHolder {
        return ActorsListViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: ActorsListViewHolder, position: Int) {
        val item = items[position]
        holder.nameActor.text = item.name
        holder.character.text = item.character
        imageLoader.loadActorAvatar(
            String.format(TmdbApiConstants.POSTER_URL, item.profilePath),
            holder.actorImage
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }
}