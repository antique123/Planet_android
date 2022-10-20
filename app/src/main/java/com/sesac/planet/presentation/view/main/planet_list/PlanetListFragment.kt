package com.sesac.planet.presentation.view.main.planet_list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentPlanetListBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetListAdapter

class PlanetListFragment : Fragment() {
    private var _binding: FragmentPlanetListBinding? = null
    private val binding get() = _binding!!
    private lateinit var planetListAdapter: PlanetListAdapter

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
        initPlanetListRecyclerView()
    }

    private fun initPlanetListRecyclerView(){
        val items = mutableListOf<String>().apply {
            add("취업준비")
            add("다이어트")
            add("인간관계")
            add("교양 지식")
            add("건강")
            add("인간관계")
            add("취업준비")
            add("다이어트")
            add("인간관계")
            add("교양 지식")
        }

        planetListAdapter = PlanetListAdapter(items)
        binding.planetListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.planetListRecyclerView.adapter = planetListAdapter

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