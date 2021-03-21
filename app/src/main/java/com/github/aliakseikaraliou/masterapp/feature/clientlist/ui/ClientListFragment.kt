package com.github.aliakseikaraliou.masterapp.feature.clientlist.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.aliakseikaraliou.masterapp.databinding.FragmentClientlistBinding
import com.github.aliakseikaraliou.masterapp.feature.clientlist.di.ClientListFragmentComponent
import com.github.aliakseikaraliou.masterapp.feature.clientlist.signal.ClientListFragmentSignal
import com.github.aliakseikaraliou.masterapp.feature.clientlist.vm.ClientListFragmentViewModel
import com.github.aliakseikaraliou.masterapp.model.Client
import com.github.aliakseikaraliou.masterapp.ui.fragment.BindingFragment
import javax.inject.Inject
import kotlin.reflect.KClass

class ClientListFragment : BindingFragment<FragmentClientlistBinding>() {

    override val bindingClass = FragmentClientlistBinding::class

    @Inject
    lateinit var viewModel: ClientListFragmentViewModel

    private val recyclerViewAdapter = ClientListFragmentRecyclerViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ClientListFragmentComponent.inject(this)

        viewModel.liveData.observe(viewLifecycleOwner) { signal ->
            when (signal) {
                is ClientListFragmentSignal.ClientListUpdated ->
                    displayClients(signal.clients)
                is ClientListFragmentSignal.ClientAdded ->
                    notify(signal)
                is ClientListFragmentSignal.Error ->
                    handleError(signal.rootSignal, signal.throwable)
            }
        }

        viewModel.loadClients()

        initViews()
    }

    private fun initViews() {
        binding.addButton.setOnClickListener {
            viewModel.addClient(Client(name = "Abc"))
        }

        binding.recycler.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    private fun notify(signal: ClientListFragmentSignal) {
        when (signal) {
            is ClientListFragmentSignal.ClientAdded ->
                Toast
                    .makeText(context, "Client ${signal.client.name} added", Toast.LENGTH_SHORT)
                    .show()
        }
    }


    private fun displayClients(clients: List<Client>) {
        Log.d(ClientListFragment::class.qualifiedName, "Displayed")
        recyclerViewAdapter.clients = clients
    }

    private fun handleError(
        rootSignal: KClass<out ClientListFragmentSignal>,
        throwable: Throwable,
    ) {
        Log.e(ClientListFragment::class.qualifiedName, rootSignal.qualifiedName, throwable)
    }

}