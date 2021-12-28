package com.example.blueprintroom.DI

import android.app.Application
import com.example.blueprintroom.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface MainComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MainComponent
    }
    fun inject(mainActivity: MainActivity)
}