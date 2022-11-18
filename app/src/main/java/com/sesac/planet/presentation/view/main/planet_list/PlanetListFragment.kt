package com.sesac.planet.presentation.view.main.planet_list

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.config.PlanetApplication
import com.sesac.planet.data.model.planet.ResultPlanetInfo
import com.sesac.planet.data.model.planet.RevisePlanetRequest
import com.sesac.planet.databinding.FragmentPlanetListBinding
import com.sesac.planet.presentation.view.main.planet_list.adapter.PlanetListAdapter
import com.sesac.planet.presentation.viewmodel.main.planet.PlanetInfoViewModel
import com.sesac.planet.presentation.viewmodel.main.planet.PlanetViewModelFactory
import com.sesac.planet.presentation.viewmodel.main.planet.RevisePlanetViewModel
import com.sesac.planet.presentation.viewmodel.main.planet.RevisePlanetViewModelFactory
import com.sesac.planet.utility.Constant
import com.sesac.planet.utility.SystemUtility

class PlanetListFragment() : Fragment() {
    private var _binding: FragmentPlanetListBinding? = null
    private val binding get() = _binding!!

    private var token = PlanetApplication.sharedPreferences.getString(Constant.X_ACCESS_TOKEN, "")
    private var journeyId = PlanetApplication.sharedPreferences.getInt(Constant.JOURNEY_ID, 0)

    private lateinit var planetListAdapter: PlanetListAdapter

    private lateinit var createPlanetLauncher: ActivityResultLauncher<Intent>

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
        createPlanetLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.data == null) {
                    Log.d("PlanetData", "data is null")

                } else {
                    Log.d("PlanetData", "data is not null")

                }
                Log.d("PlanetData", "resultCode == RESULT_OK")
                val color = result.data?.getStringExtra("color")
                val planetId = result.data?.getIntExtra("planetId", -1)
                val planetIntro = result.data?.getStringExtra("planetIntro")
                val planetName = result.data?.getStringExtra("planetName")
                val planCount = result.data?.getIntExtra("planCount", -1)

                Log.d("PlanetData", "color: ${color}")
                Log.d("PlanetData", "planetId: ${planetId}")
                Log.d("PlanetData", "planetIntro: ${planetIntro}")
                Log.d("PlanetData", "planetName: ${color}")
                Log.d("PlanetData", "planCount: ${planCount}")


                if (color != null && planetId != -1 && planetIntro != null && planetName != null && planCount != -1) {
                    Log.d("DynamicTest", "call")
                    planetListAdapter.addItem(
                        ResultPlanetInfo(
                            planetId!!, planetName, planetIntro, 0, 1, planCount!!, color
                        )
                    )
                } else {
                    Log.d("DynamicTest", "not called")

                }
            }
    }

    private fun initView() {
        initPlanetListRecyclerView()
        binding.planetListMenuOptionBtn.setOnClickListener {
            val intent = Intent(requireContext(), CreatePlanetActivity::class.java)
            createPlanetLauncher.launch(intent)
        }

        binding.refreshContainer.setOnRefreshListener {
            token?.let {
                viewModel.getPlanet(
                    it,
                    journeyId
                )
            }
        }
    }

    private fun initPlanetListRecyclerView() {
        initObservers()
        token?.let {
            viewModel.getPlanet(
                it,
                journeyId
            )
        }
    }

    private fun initObservers() {
        viewModel.planetData.observe(viewLifecycleOwner) { response ->
            binding.refreshContainer.isRefreshing = false
            if (response.isSuccessful) {
                response.body()?.result.let { body ->
                    if (body == null) {

                    } else {
                        planetListAdapter =
                            PlanetListAdapter(body as MutableList<ResultPlanetInfo>?)
                        binding.planetListRecyclerView.layoutManager =
                            GridLayoutManager(requireContext(), 2)
                        binding.planetListRecyclerView.adapter = planetListAdapter

                        planetListAdapter.setItemClickListener(
                            object : PlanetListAdapter.OnItemClickListener {
                                override fun onClick(v: View, position: Int) {
                                    val intent =
                                        Intent(requireContext(), PlanetDetailActivity::class.java)
                                    intent.putExtra("planet_id", body?.get(position)?.planet_id)
                                    startActivity(intent)
                                }
                            })

                        planetListAdapter.setItemLongClickListener(
                            object : PlanetListAdapter.OnItemLongClickListener {
                                override fun onLongClick(
                                    v: View,
                                    position: Int,
                                    deletePlanetId: Int
                                ) {

                                    val deleteDialog = DeletePlanetDialog(deletePlanetId)
                                    activity?.let {
                                        deleteDialog.show(
                                            it.supportFragmentManager,
                                            "DeletePlanetDialog"
                                        )
                                    }


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