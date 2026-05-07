// Adaptador de RecyclerView para vincular la lista de docentes con la vista.
package com.tuapp.ui.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuapp.R
import com.tuapp.data.model.Professor

class ProfessorAdapter(private var professors: List<Professor>) :
    RecyclerView.Adapter<ProfessorAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvProfessorName)
        val tvDepartment: TextView = view.findViewById(R.id.tvDepartment)
        val tvRating: TextView = view.findViewById(R.id.tvRating)
        val tvReviews: TextView = view.findViewById(R.id.tvReviewsCount)
    }

    /**
     * Crea e infla la vista del ítem de profesor.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profesor, parent, false)
        return ViewHolder(view)
    }

    /**
     * Vincula los datos de un profesor con los elementos visuales del ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val professor = professors[position]
        holder.tvName.text = professor.fullName
        holder.tvDepartment.text = professor.department
        holder.tvRating.text = holder.itemView.context.getString(R.string.label_rating, professor.averageRating)
        holder.tvReviews.text = holder.itemView.context.getString(R.string.label_reviews, professor.reviewsCount)
    }

    /**
     * Retorna la cantidad de elementos en la lista.
     */
    override fun getItemCount() = professors.size

    /**
     * Actualiza la lista de profesores y refresca el RecyclerView.
     */
    fun updateData(newProfessors: List<Professor>) {
        professors = newProfessors
        notifyDataSetChanged()
    }
}
