package com.omar.tShoestore.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.omar.tShoestore.R
import com.omar.tShoestore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {
    private lateinit var binding : InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.instruction_fragment, container, false)

        binding.getStarted.setOnClickListener {
            view : View ->
            view.findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment)
        }

        return binding.root
    }
}