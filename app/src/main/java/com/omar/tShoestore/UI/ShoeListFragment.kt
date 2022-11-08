package com.omar.tShoestore.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.omar.tShoestore.R
import com.omar.tShoestore.databinding.ListViewBinding
import com.omar.tShoestore.databinding.ShoelistFragmentBinding
import com.omar.tShoestore.model.Shoe
import com.omar.tShoestore.viewModel.ShoeViewModel

class ShoeListFragment :Fragment() {

    private lateinit var  binding : ShoelistFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.shoelist_fragment, container, false)

        val viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            item -> viewShowList(item)
        })

        binding.fab.setOnClickListener {
            view : View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }
    return binding.root
    }

    private fun viewShowList(item: List<Shoe>?) {
        item?.forEach{
            val bindingView = ListViewBinding.inflate(LayoutInflater.from(requireContext()), binding.listLayout, false)
            with(bindingView){
                nameTv.text = it.name
                sizeTv.text=it.size
                companyTv.text=it.company
                descriptionTv.text=it.description
            }
            binding.listLayout.addView(bindingView.root)
        }
    }


}