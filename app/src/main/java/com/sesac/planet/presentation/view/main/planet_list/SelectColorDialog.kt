package com.sesac.planet.presentation.view.main.planet_list

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.sesac.planet.databinding.DialogSelectPlanetColorBinding

class SelectColorDialog() : DialogFragment() {
    private lateinit var binding: DialogSelectPlanetColorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogSelectPlanetColorBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCanceledOnTouchOutside(true)
        dialog?.setCancelable(false)

        binding.dialogSelectExitImg.setOnClickListener {
            dismiss()
        }

        binding.dialogSaveBtn.setOnClickListener {
            //저장
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this, 0.9f)
    }


    //디바이스 가로의 90% 사이즈
    private fun Context.dialogFragmentResize(dialogFragment: DialogFragment, width: Float) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        if (Build.VERSION.SDK_INT < 30) {
            val display = windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            val window = dialogFragment.dialog?.window
            val x = (size.x * width).toInt()
            window?.setLayout(x, ViewGroup.LayoutParams.WRAP_CONTENT)

        } else {
            val rect = windowManager.currentWindowMetrics.bounds
            val window = dialogFragment.dialog?.window
            val x = (rect.width() * width).toInt()
            window?.setLayout(x, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }
}