package com.example.blueprintroom

import android.app.Application
import com.example.blueprintroom.DI.DaggerMainComponent
import com.example.blueprintroom.DI.MainComponent
import dagger.Component

class MyApp: Application() {
    lateinit var mainComponent: MainComponent
    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent
            .builder()//базовая комплектация
            .application(this)//опциональное дополнение(для передачи для создания Room/Retrofit)
            .build()//окончательная сборка
    }
}