package com.lenibonje.habari.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.databinding.NewsListItemBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val callback = object: DiffUtil.ItemCallback<Article>(){

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    inner class NewsViewHolder(val binding: NewsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(article: Article){
                binding.apply {
                    tvDescription.text = article.description
                    tvSource.text = article.source.name
                    tvPublishedAt.text = article.publishedAt
                    tvTitle.text = article.title
                    Glide.with(binding.ivArticleImage)
                        .load(article.urlToImage)
                        .into(binding.ivArticleImage)
                    root.setOnClickListener {
                        onItemClickListener?.let {
                            it(article)
                        }
                    }
                }
            }

    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit){
        onItemClickListener = listener
    }


}