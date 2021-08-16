package com.komala.komalexclusive_kotlin.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.komala.komalexclusive_kotlin.R
import com.komala.komalexclusive_kotlin.databinding.FragmentWeatherBinding
import com.komala.komalexclusive_kotlin.model.weather.Weather

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var weatherViewModel: WeatherViewModel
private var _binding : FragmentWeatherBinding? = null
private var searchString: String? = null

// This property is only valid between onCreateView and
// onDestroyView.
private val binding get() = _binding!!
/**
 * A simple [Fragment] subclass.
 * Use the [WeatherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_weather, container, false)
        val toolbar = root.findViewById(R.id.toolbar) as Toolbar?
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        weatherViewModel.successWeatherReport.observe(viewLifecycleOwner, Observer { weather: Weather ->
            run {
                if (weather != null) {
                    activity?.let {
                        Glide.with(it).load(weather.current?.weatherIcons?.get(0))
                            .into(binding.ivIconWeather)
                    };
                    binding.tvLocationWeather.setText(weather.location?.name);
                    binding.tvRegionWeather.setText(weather.location?.region);
                    binding.tvCountryWeather.setText(weather.location?.country);
                    binding.tvTimeWeather.setText(weather.current?.observationTime);
                    binding.tvTempWeather.setText(weather.current?.temperature.toString());
                    binding.tvHumidityWeather.setText(weather.current?.humidity.toString());
                    binding.tvDescriptionWeather.setText(
                        weather.current?.weatherDescriptions?.get(0)
                    );
                }
            }
        })
        weatherViewModel.failureWeatherReport.observe(viewLifecycleOwner, Observer { error: String -> run{
        if (error != null){
            Toast.makeText(activity, error , Toast.LENGTH_SHORT)
        }
        } })
        binding.etInputPlace.setOnClickListener({ v:View ->
            run {
                val searchString: String = binding.etInputPlace.getText().toString()
                weatherViewModel.loadCurrentWeatherReport(searchString)
            }
        })
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WeatherFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WeatherFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}