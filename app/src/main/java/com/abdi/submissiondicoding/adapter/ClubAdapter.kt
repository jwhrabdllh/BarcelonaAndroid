package com.abdi.submissiondicoding.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdi.submissiondicoding.R
import com.abdi.submissiondicoding.data.Club
import com.abdi.submissiondicoding.ui.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ClubAdapter(private val listTeam: ArrayList<Club>)
    : RecyclerView.Adapter<ClubAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pemain, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val team = listTeam[position]
        val context = holder.itemView.context

        Glide.with(context)
            .load(team.photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = team.name
        holder.tvDetail.text = team.detail

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(context, DetailActivity::class.java)
            moveDetail.putExtra(DetailActivity.EXTRA_NAME, team.name)
            moveDetail.putExtra(DetailActivity.EXTRA_DETAIL, team.detail)
            moveDetail.putExtra(DetailActivity.EXTRA_PHOTO, team.photo)
            moveDetail.putExtra(DetailActivity.EXTRA_INFORMATION, team.information)
            context.startActivity(moveDetail)
        }
    }

    override fun getItemCount() = listTeam.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}