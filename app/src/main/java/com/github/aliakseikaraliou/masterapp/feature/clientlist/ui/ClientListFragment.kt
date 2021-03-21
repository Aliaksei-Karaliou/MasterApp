package com.github.aliakseikaraliou.masterapp.feature.clientlist.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.aliakseikaraliou.masterapp.databinding.FragmentClientlistBinding
import com.github.aliakseikaraliou.masterapp.feature.clientlist.di.ClientListFragmentComponent
import com.github.aliakseikaraliou.masterapp.feature.clientlist.vm.ClientListFragmentViewModel
import com.github.aliakseikaraliou.masterapp.ui.fragment.BindingFragment
import javax.inject.Inject

class ClientListFragment : BindingFragment<FragmentClientlistBinding>() {

    override val bindingClass = FragmentClientlistBinding::class

    @Inject
    lateinit var viewModel: ClientListFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ClientListFragmentComponent.inject(this)
        Toast.makeText(context, "Fragment", Toast.LENGTH_SHORT).show()
    }
}