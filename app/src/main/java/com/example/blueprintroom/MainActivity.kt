package com.example.blueprintroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.blueprintroom.DI.MainComponent
import com.example.blueprintroom.DI.ViewModelFactory
import com.example.blueprintroom.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainComponent: MainComponent
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as MyApp).mainComponent
        mainComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.readData()
        println(viewModel.repository)
        binding.button.setOnClickListener({
            viewModel.addData(binding.textView.text.toString(),binding.textView2.text.toString(), binding.textView3.text.toString())
        })
    }
}