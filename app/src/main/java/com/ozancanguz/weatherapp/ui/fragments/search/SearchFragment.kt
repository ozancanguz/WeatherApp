package com.ozancanguz.weatherapp.ui.fragments.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.weatherapp.R
import com.ozancanguz.weatherapp.data.adapters.WeatherAdapter
import com.ozancanguz.weatherapp.databinding.FragmentSearchBinding
import com.ozancanguz.weatherapp.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    private val weatherViewModel:WeatherViewModel by viewModels()
    private val weatherAdapter=WeatherAdapter()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        // setting up recyclerview
        setupRv()

        // observe live data and update ui
         observeliveData()

        return view
    }

    private fun observeliveData() {

       binding.searchBtn.setOnClickListener {
           binding.pb.visibility=View.VISIBLE
           val lang="tr"
           val city=binding.searchEditText.text.toString()
           weatherViewModel.getWeather(lang,city)
           weatherViewModel.weatherList.observe(viewLifecycleOwner, Observer {
               weatherAdapter.setData(it)
               binding.pb.visibility=View.INVISIBLE


           })


       }
    }

    private fun setupRv() {
        binding.searchRv.layoutManager=LinearLayoutManager(requireContext())
        binding.searchRv.adapter=weatherAdapter
    }


}