package com.github.aliakseikaraliou.masterapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BindingFragment<T : ViewBinding> : Fragment() {

    abstract val bindingClass: KClass<T>

    private var _binding: T? = null
    protected val binding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val method = bindingClass::java.get()
            .getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )
        _binding = method.invoke(null, layoutInflater, container, false) as T

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}