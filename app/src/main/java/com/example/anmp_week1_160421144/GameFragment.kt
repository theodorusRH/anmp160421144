package com.example.anmp_week1_160421144

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmp_week1_160421144.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {

    var hasil = 0
    var poin = 0

    private lateinit var binding:FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's turn "
            this.hasil = setEquation()
        }

        binding.btnSubmit.setOnClickListener {
            var userAnswer:String = binding.txtAnswer.text.toString()
            if (userAnswer.toInt() == this.hasil) {
                this.poin += 1
                this.hasil = setEquation()
            }
            else {
                val action = GameFragmentDirections.actiongameFragmentresultFragment(poin)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun setEquation():Int {
        var randomNumber1 = Random.nextInt(0, 100)
        var randomNumber2 = Random.nextInt(0, 100)
        binding.txtNumber1.text = randomNumber1.toString()
        binding.txtNumber2.text = randomNumber2.toString()

        var result = randomNumber1 + randomNumber2
        return result
    }
}