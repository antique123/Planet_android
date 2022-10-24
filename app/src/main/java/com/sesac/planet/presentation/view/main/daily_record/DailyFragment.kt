package com.sesac.planet.presentation.view.main.daily_record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.databinding.FragmentDailyBinding
import com.sesac.planet.presentation.view.main.daily_record.adapter.DailyAdapter
import org.jetbrains.annotations.TestOnly


class DailyFragment : Fragment() {
    private var _binding: FragmentDailyBinding? = null
    private val binding get() = _binding!!
    private val dailyAdapter by lazy { DailyAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        initDailyRecyclerView()
    }

    private fun initDailyRecyclerView() {
        binding.dailyRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 2, GridLayoutManager.VERTICAL, false)
        binding.dailyRecyclerView.adapter = dailyAdapter
        bindInfiniteScroll()

        dailyAdapter.setItems(makeItems())
    }

    private fun bindInfiniteScroll() {
        binding.dailyRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                GridLayoutManager::class.java.cast(binding.dailyRecyclerView.layoutManager)?.apply {
                    val lastItemPosition = this.itemCount - 1
                    val lastVisibleItemPosition = findLastCompletelyVisibleItemPosition()
                    if(lastVisibleItemPosition >= lastItemPosition - 4) {
                        dailyAdapter.setItems(makeItems())
                    }
                }
            }
        })
    }

    //TODO API 연결 전 임시로 사용하는 메서드입니다.
    private fun makeItems(): MutableList<String> {
        val items = mutableListOf<String>().apply {
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")
            add("https://blog.kakaocdn.net/dn/cdl7tc/btrh4ovGa1U/WwGSBcqQSG53s584whFiM0/img.jpg")

        }
        return items
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}