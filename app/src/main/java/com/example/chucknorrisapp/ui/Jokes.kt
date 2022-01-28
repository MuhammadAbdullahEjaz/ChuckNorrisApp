package com.example.chucknorrisapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.chucknorrisapp.JokesViewModel
import com.example.chucknorrisapp.JokesViewModelFactory
import com.example.chucknorrisapp.databinding.FragmentJokesBinding
import com.example.chucknorrisapp.repository.MainRepository


class Jokes : Fragment() {

    private lateinit var binding:FragmentJokesBinding
    private val viewModel:JokesViewModel by activityViewModels { JokesViewModelFactory(MainRepository()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJokesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        viewModel.randomJokes()
        viewModel.jokesCategories()

        binding.refresh.setOnClickListener{
            viewModel.randomJokes()
        }
    }

}