package com.example.weatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSettingsBinding
import com.example.weatherapp.viewModel.settingsPage.SettingsPageViewModel


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SettingsPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(layoutInflater)

        binding.sendFeedback.setOnClickListener() {
            viewModel.sendFeedback(requireContext())
        }

        binding.temperatureFormatToggle.setOnClickListener() {
            viewModel.formatChanged(getString(R.string.temperature_format))
        }

        binding.darkModeText.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.darkMode(isChecked)
        }

        return binding.root
    }

}