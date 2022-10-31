package com.sesac.planet.presentation.view.main.planet_list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentPlanetListBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetListAdapter
import com.sesac.planet.presentation.viewmodel.main.PlanetInfoViewModel
import com.sesac.planet.utility.SystemUtility

class PlanetListFragment : Fragment() {
    private var _binding: FragmentPlanetListBinding? = null
    private val binding get() = _binding!!
    private lateinit var planetListAdapter: PlanetListAdapter

    private val viewModel = ViewModelProvider(this)[PlanetInfoViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()

        binding.planetListMenuOptionBtn.setOnClickListener {
            var popupMenu = PopupMenu(context, it)

            activity?.menuInflater?.inflate(R.menu.menu_planet_list_option, popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener {
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                return@setOnMenuItemClickListener false
            }
        }
    }

    private fun initialize(){
        SystemUtility.applyWindowInsetsTopPadding(binding.root)
        initPlanetListRecyclerView()
    }

    private fun initPlanetListRecyclerView(){
        viewModel.itemList.observe(viewLifecycleOwner, Observer {
            planetListAdapter = PlanetListAdapter(it)
            binding.planetListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.planetListRecyclerView.adapter = planetListAdapter
        })

        planetListAdapter.setItemClickListener(object : PlanetListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val intent = Intent(context, PlanetDetailActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}