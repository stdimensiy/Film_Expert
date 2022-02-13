package ru.vdv.filmexpert.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.filmexpert.databinding.ItemListActorsBinding

class ActorsListViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemListActorsBinding = ItemListActorsBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    val actorImage = binding.ivActorProfile
    val nameActor = binding.tvActorName
    val character = binding.tvCharacter
}