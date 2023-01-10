package com.lenibonje.habari.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lenibonje.habari.R
import com.lenibonje.habari.data.util.Resource
import com.lenibonje.habari.databinding.FragmentNewsBinding
import com.lenibonje.habari.presentation.viewmodel.NewsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsAdapter: NewsAdapter
    private var county = "us"
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        newsAdapter = (activity as MainActivity).adapter
        initRecyclerView()
    }

    private fun initRecyclerView() {
//        newsAdapter = NewsAdapter()
        binding.rvNews.adapter = newsAdapter

    }

    private fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        binding.progressBar.visibility = View.GONE
    }

    private fun viewNewsList(){
        viewModel.getNewsHeadLines(county, page)
        viewModel.newsHeadLines.observe(viewLifecycleOwner){ response ->
            when(response){
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(requireContext(), "an error occurred", Toast.LENGTH_SHORT).show()
                    }
                }
                is Resource.Loading -> showProgressBar()
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles.toList())
                    }

                }
            }
        }
    }
}