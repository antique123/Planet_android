package com.sesac.planet.presentation.view.main.planet_list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.data.model.planet.RevisePlanetRequest
import com.sesac.planet.databinding.FragmentPlanetListBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetListAdapter
import com.sesac.planet.presentation.viewmodel.main.planet.PlanetInfoViewModel
import com.sesac.planet.presentation.viewmodel.main.planet.PlanetViewModelFactory
import com.sesac.planet.presentation.viewmodel.main.planet.RevisePlanetViewModel
import com.sesac.planet.presentation.viewmodel.main.planet.RevisePlanetViewModelFactory
import com.sesac.planet.utility.SystemUtility

class PlanetListFragment() : Fragment(){
    private var _binding: FragmentPlanetListBinding? = null
    private val binding get() = _binding!!

    private var args = Bundle()
    private var delPlanetId: Int = 0

    private lateinit var planetListAdapter: PlanetListAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            PlanetViewModelFactory()
        )[PlanetInfoViewModel::class.java]
    }

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
        initView()
    }

    private fun initialize() {
        SystemUtility.applyWindowInsetsTopPadding(binding.root)
    }

    private fun initView() {
        initPlanetListRecyclerView()
        binding.planetListMenuOptionBtn.setOnClickListener {
            val intent = Intent(requireContext(), CreatePlanetActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initPlanetListRecyclerView() {
        initObservers()
        viewModel.getPlanet(
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxMSwiaWF0IjoxNjY3NjI2OTA1LCJleHAiOjE2NjkwOTgxMzR9.1IgJRf7fl08M0_5DZPff8a5GCH79hpyFtGkGET5ZtgM",
            6
        )
    }

    private fun initObservers() {
        viewModel.planetData.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.result.let { body ->
                    if (body == null) {

                    } else {
                        planetListAdapter = PlanetListAdapter(body)
                        binding.planetListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                        binding.planetListRecyclerView.adapter = planetListAdapter

                        planetListAdapter.setItemClickListener(
                            object : PlanetListAdapter.OnItemClickListener {
                                override fun onClick(v: View, position: Int) {
                                    val intent = Intent(requireContext(), PlanetDetailActivity::class.java)
                                    intent.putExtra("planet_id", body?.get(position)?.planet_id)
                                    startActivity(intent)
                                }
                            })

                        planetListAdapter.setItemLongClickListener(
                            object : PlanetListAdapter.OnItemLongClickListener{
                                override fun onLongClick(
                                    v: View,
                                    position: Int,
                                    deletePlanetId: Int
                                ) {
                                    val deleteDialog = DeletePlanetDialog(deletePlanetId)
                                    activity?.let { deleteDialog.show(it.supportFragmentManager, "DeletePlanetDialog") }
                                }
                            }
                        )

                    }
                }
            } else {
                //서버에 문제가 생겼을 때
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}