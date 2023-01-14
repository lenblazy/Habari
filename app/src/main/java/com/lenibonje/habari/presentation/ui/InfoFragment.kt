package com.lenibonje.habari.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.lenibonje.habari.R
import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.databinding.FragmentInfoBinding
import com.lenibonje.habari.presentation.viewmodel.NewsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [InfoFragment] factory method to
 * create an instance of this fragment.
 */
class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        arguments?.let {
            val article = it.getSerializable("article") as Article?
            if (article != null){
                binding.webView.apply {
                    webViewClient = WebViewClient()
                    article.url?.let { url ->
                        loadUrl(url)
                    }
                }

                binding.fabSave.setOnClickListener { view ->
                    viewModel.saveArticle(article)
                    Snackbar.make(view, "Saved Successfully", Snackbar.LENGTH_LONG).show()
                }
            }

        }
    }


}