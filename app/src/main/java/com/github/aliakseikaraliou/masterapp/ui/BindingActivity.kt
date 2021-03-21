package com.github.aliakseikaraliou.masterapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BindingActivity<T : ViewBinding> : AppCompatActivity() {

    abstract val bindingClass: KClass<T>

    protected val binding: T by lazy {
        val method = bindingClass::java.get().getMethod("inflate", LayoutInflater::class.java)
        method.invoke(null, layoutInflater) as T
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}