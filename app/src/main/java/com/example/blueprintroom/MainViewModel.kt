package com.example.blueprintroom

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(var repository: Repository): ViewModel() {
    fun addData(first: String, last: String, born: String){
        repository.addData(first, last,born)
    }
    fun readData(){
        repository.readData()
    }
}
