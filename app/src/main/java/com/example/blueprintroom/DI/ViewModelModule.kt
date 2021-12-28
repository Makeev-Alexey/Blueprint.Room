package com.example.blueprintroom.DI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.blueprintroom.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(model: MainViewModel): ViewModel
}