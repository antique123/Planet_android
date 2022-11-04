package com.sesac.planet.presentation.view.settings

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.DialogHomeAddToDoBinding
import com.sesac.planet.presentation.view.settings.adapter.DialogSelectAdapter

class HomeAddToDoDialog(context: Context) : Dialog(context) {
    private lateinit var binding: DialogHomeAddToDoBinding
    private lateinit var dialogSelectAdapter: DialogSelectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogHomeAddToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context.dialogResize(this@HomeAddToDoDialog, 0.9f)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //setCanceledOnTouchOutside(true)
        //setCancelable(false)

        binding.dialogHomeChoiceRadioBtn.setOnCheckedChangeListener { button, b ->
            if (button.isChecked) {
                binding.dialogHomeWeekCheckGroup.visibility = View.VISIBLE
            } else if(!button.isChecked){
                binding.dialogHomeWeekCheckGroup.visibility = View.GONE
                initWeekGroup()
            }
        }

        initSelectPlanet()
    }

    private fun initSelectPlanet(){
        val items = mutableListOf<String>().apply {
            add("해당없음")
            add("취업준비")
            add("다이어트")
            add("인간관계")
            add("교양지식")
            add("건강관리")
        }

        dialogSelectAdapter = DialogSelectAdapter(items)
        binding.dialogHomeSelectPlanetRecycler.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL, false )
        binding.dialogHomeSelectPlanetRecycler.adapter = dialogSelectAdapter
    }

    //디바이스 가로의 90% 사이즈
    fun Context.dialogResize(dialog: Dialog, width: Float) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        if (Build.VERSION.SDK_INT < 30) {
            val display = windowManager.defaultDisplay
            val size = Point()

            display.getSize(size)

            val window = dialog.window

            val x = (size.x * width).toInt()

            window?.setLayout(x, ViewGroup.LayoutParams.WRAP_CONTENT)

        } else {
            val rect = windowManager.currentWindowMetrics.bounds

            val window = dialog.window
            val x = (rect.width() * width).toInt()

            window?.setLayout(x, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

    }

    private fun initWeekGroup(){
        binding.dialogHomeMonCheckBtn.isChecked = false
        binding.dialogHomeTueCheckBtn.isChecked = false
        binding.dialogHomeWedCheckBtn.isChecked = false
        binding.dialogHomeThurCheckBtn.isChecked = false
        binding.dialogHomeFriCheckBtn.isChecked = false
        binding.dialogHomeSatCheckBtn.isChecked = false
        binding.dialogHomeSunCheckBtn.isChecked = false
    }
}