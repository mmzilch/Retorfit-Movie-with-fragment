package com.example.retrofitmoviehomework.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmoviehomework.R
import com.example.retrofitmoviehomework.Model.Result
import com.squareup.picasso.Picasso


import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter:RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    var resultList: List<Result> = listOf()

    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindMovie(result:Result){
            Picasso.get().load("https://image.tmdb.org/t/p/w200${result.poster_path}")
                .placeholder(R.drawable.ic_launcher_background).into(itemView.imageMovie)//place holder is to show temp image when loading
            itemView.tvMovieName.text = result.title
            itemView.tvDate.text  = result.release_date
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
        Log.d("new>>>>>",resultList.size.toString())
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(resultList[position])
    }

    fun updateList(result : List<Result>)
    {
        this.resultList = result
        notifyDataSetChanged()
    }

}