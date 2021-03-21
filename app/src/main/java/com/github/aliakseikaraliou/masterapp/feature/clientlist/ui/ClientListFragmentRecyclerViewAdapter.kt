package com.github.aliakseikaraliou.masterapp.feature.clientlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.aliakseikaraliou.masterapp.databinding.ItemClientlistBinding
import com.github.aliakseikaraliou.masterapp.feature.clientlist.ui.ClientListFragmentRecyclerViewAdapter.ClientListFragmentRecyclerViewViewHolder
import com.github.aliakseikaraliou.masterapp.model.Client

class ClientListFragmentRecyclerViewAdapter : RecyclerView.Adapter<ClientListFragmentRecyclerViewViewHolder>() {

    var clients = listOf<Client>()
        set(value) {
            val diffUtilCallback = ClientListDiffUtilCallback(clients, value)
            field = value

            DiffUtil
                .calculateDiff(diffUtilCallback)
                .dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientListFragmentRecyclerViewViewHolder {
        return ClientListFragmentRecyclerViewViewHolder(
            ItemClientlistBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: ClientListFragmentRecyclerViewViewHolder, position: Int) {
        holder.update(clients[position])
    }

    override fun getItemCount() = clients.size

    class ClientListFragmentRecyclerViewViewHolder(val binding: ItemClientlistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun update(client: Client) {
            binding.title.text = client.name
        }
    }

    class ClientListDiffUtilCallback(
        private val old: List<Client>,
        private val new: List<Client>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = old.size
        override fun getNewListSize() = new.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = old[oldItemPosition].id == new[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = old[oldItemPosition] == new[newItemPosition]

    }
}