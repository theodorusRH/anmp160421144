package com.example.anmp_week1_160421144

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmp_week1_160421144.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding:FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            var score = ResultFragmentArgs.fromBundle(requireArguments()).poin
            binding.txtScore.text = "Your score is $score"
        }

        binding.btnBackResult.setOnClickListener {
            val action = ResultFragmentDirections.actionresultFragmentmainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}