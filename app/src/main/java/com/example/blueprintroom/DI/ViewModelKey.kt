package com.example.blueprintroom.DI
import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey//основная аннотация
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)//расширяемая аннотация