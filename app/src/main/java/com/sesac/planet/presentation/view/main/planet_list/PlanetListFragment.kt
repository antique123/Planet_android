package com.sesac.planet.presentation.view.main.planet_list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.R
import com.sesac.planet.data.model.PlanetListData
import com.sesac.planet.databinding.FragmentPlanetListBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetListAdapter
import com.sesac.planet.presentation.viewmodel.main.PlanetInfoViewModel
import com.sesac.planet.utility.SystemUtility

class PlanetListFragment : Fragment() {
    private var _binding: FragmentPlanetListBinding? = null
    private val binding get() = _binding!!
    private lateinit var planetListAdapter: PlanetListAdapter

    private lateinit var viewModel: PlanetInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[PlanetInfoViewModel::class.java]

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

    private fun initialize() {
        SystemUtility.applyWindowInsetsTopPadding(binding.root)
        initPlanetListRecyclerView()
    }

    private fun initPlanetListRecyclerView() {
        val items = arrayListOf(
            PlanetListData(R.drawable.ic_planet_purple, "취업준비", "원하는 회사 찾고 이력서, 포트폴리오", 3, 3),
            PlanetListData(R.drawable.ic_planet_mint, "다이어트", "올 겨울까지 10kg 감량", 1, 7),
            PlanetListData(R.drawable.ic_planet_apricot, "인간관계", "연인관계, 친구관계", 3, 3),
            PlanetListData(R.drawable.ic_planet_navy, "교양 지식", "마음의 양식 책읽기 30권", 8, 5),
            PlanetListData(R.drawable.ic_planet_yellow, "건강", "피부, 눈, 건강 체력 관리", 3, 6),
            PlanetListData(R.drawable.ic_planet_mono, "인간관계", "연인관계, 친구관계", 8, 1)
        )

        planetListAdapter = PlanetListAdapter(items)
        binding.planetListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.planetListRecyclerView.adapter = planetListAdapter

        planetListAdapter.setItemClickListener(
            object : PlanetListAdapter.OnItemClickListener {
                override fun onClick(v: View, position: Int) {
                    val intent = Intent(requireContext(), PlanetDetailActivity::class.java)
                    intent.putExtra("keyword", items[position].planetName)
                    startActivity(intent)
                }
            })

        /*
        viewModel.itemList.observe(viewLifecycleOwner){
            planetListAdapter = PlanetListAdapter(it)
        }

        viewModel.setData()
         */
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}