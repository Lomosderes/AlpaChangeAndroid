// Adaptador para mostrar la lista de peticiones en un RecyclerView.
package com.tuapp.ui.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuapp.R
import com.tuapp.data.model.Petition

class PetitionAdapter(private var petitions: List<Petition>) :
    RecyclerView.Adapter<PetitionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvAuthor: TextView = view.findViewById(R.id.tvAuthor)
        val tvVotes: TextView = view.findViewById(R.id.tvVotes)
        val tvCategory: TextView = view.findViewById(R.id.tvCategory)
    }

    /**
     * Infla el diseño del ítem de petición y crea el ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_peticion, parent, false)
        return ViewHolder(view)
    }

    /**
     * Vincula los datos de una petición específica con los elementos visuales del ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val petition = petitions[position]
        holder.tvTitle.text = petition.title
        holder.tvAuthor.text = holder.itemView.context.getString(R.string.label_author, petition.authorAlias)
        holder.tvVotes.text = holder.itemView.context.getString(R.string.label_votes, petition.votesCount)
        holder.tvCategory.text = petition.category ?: ""
    }

    /**
     * Devuelve la cantidad total de peticiones en la lista.
     */
    override fun getItemCount() = petitions.size

    /**
     * Actualiza la lista de datos del adaptador y notifica los cambios a la UI.
     */
    fun updateData(newPetitions: List<Petition>) {
        petitions = newPetitions
        notifyDataSetChanged()
    }
}
