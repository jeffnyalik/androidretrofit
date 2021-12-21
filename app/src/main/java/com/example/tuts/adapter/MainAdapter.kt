package com.example.tuts.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tuts.model.User
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.row_type.textViewUserName
import kotlinx.android.synthetic.main.row_type.imageViewAvatar
import kotlinx.android.synthetic.main.row_type.textViewUserEmail
import com.example.tuts.R
import kotlinx.android.synthetic.main.row_type.view.*
import com.bumptech.glide.Glide
import com.example.tuts.adapter.MainAdapter.DataViewHolder


class MainAdapter(private val users: ArrayList<User>): RecyclerView.Adapter<DataViewHolder>() {
    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(user: User){
            itemView.apply {
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(imageViewAvatar)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_type, parent, false))
    override fun getItemCount(): Int = users.size
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }
    fun addUsers(users:List<User>){
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}