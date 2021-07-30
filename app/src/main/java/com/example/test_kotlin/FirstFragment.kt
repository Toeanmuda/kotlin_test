package com.example.test_kotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_kotlin.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!


    private val listItemAdapterPaging: ListItemAdapterPaging by lazy {
        ListItemAdapterPaging(inItemClick = {
            Log.d("CLISK", "SJNSX")
            val actions =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(it.url)
            findNavController().navigate(actions)
        })
    }

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = listItemAdapterPaging
        }

    /*    viewLifecycleOwner.lifecycleScope.launch {
            mainViewModel.getListPagingOfflinEOnline.collectLatest { it ->
                listItemAdapterPaging.submitData(it)
            };

        }
    */ viewLifecycleOwner.lifecycleScope.launch {
            mainViewModel.getListPaging.observe(
                viewLifecycleOwner,
                { allowPLayingMoview ->
                    listItemAdapterPaging.submitData(lifecycle, allowPLayingMoview)
                });

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}