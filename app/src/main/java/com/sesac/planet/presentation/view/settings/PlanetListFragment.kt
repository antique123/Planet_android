package com.sesac.planet.presentation.view.settings

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentPlanetListBinding
import com.sesac.planet.presentation.view.settings.adapter.PlanetListAdapter

class PlanetListFragment : Fragment() {
    private var _binding: FragmentPlanetListBinding? = null
    private val binding get() = _binding!!
    private lateinit var planetListAdapter: PlanetListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanetListBinding.inflate(inflater, container, false)

        binding.planetListMoreTextView.setOnClickListener {
            var pop = PopupMenu(context, binding.planetListMoreTextView)
            activity?.menuInflater?.inflate(R.menu.planet_list_option, pop.menu)

            pop.setOnMenuItemClickListener { item ->
                Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                false
            }
            pop.show()
        }

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        initPlanetListRecyclerView()
    }

    private fun initPlanetListRecyclerView() {
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

        planetListAdapter.setItemClickListener(object : PlanetListAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireContext(), PlanetDetailActivity::class.java)
                intent.putExtra("key", items[position])
                startActivity(intent)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}