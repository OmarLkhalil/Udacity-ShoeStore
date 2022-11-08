package com.omar.tShoestore.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omar.tShoestore.model.Shoe

class ShoeViewModel : ViewModel() {

    var shoeList = mutableListOf<Shoe>()

    var shoes = MutableLiveData<List<Shoe>>()

    val _shoes: MutableLiveData<List<Shoe>>
            get() = shoes

    fun saveShoes(name: String, company: String, size: String, description: String){
        val newItem = Shoe(name, company, size, description)
        newItem.let{
            item ->
            shoeList.add(item)
            shoes.value = shoeList
        }
    }
}