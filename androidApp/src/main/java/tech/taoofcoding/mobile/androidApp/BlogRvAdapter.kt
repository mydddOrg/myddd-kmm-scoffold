package tech.taoofcoding.mobile.androidApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jetbrains.handson.androidApp.R
import tech.taoofcoding.mobile.shared.entity.BlogDTO

class BlogRvAdapter(var launches: List<BlogDTO>) : RecyclerView.Adapter<BlogRvAdapter.BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
            .run {
                BlogViewHolder(this)
            }
    }

    override fun getItemCount(): Int = launches.count()

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bindData(launches[position])
    }

    inner class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView = itemView.findViewById<TextView>(R.id.titleText)
        private val dateTextView = itemView.findViewById<TextView>(R.id.dateText)
        private val briefTextView = itemView.findViewById<TextView>(R.id.briefText)

        fun bindData(blogDTO: BlogDTO) {
            titleTextView.text = blogDTO.title
            dateTextView.text = blogDTO.date
            briefTextView.text = blogDTO.brief
        }
    }
}