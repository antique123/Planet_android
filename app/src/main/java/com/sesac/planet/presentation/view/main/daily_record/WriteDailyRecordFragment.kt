package com.sesac.planet.presentation.view.main.daily_record

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import androidx.fragment.app.DialogFragment
import com.sesac.planet.databinding.FragmentWriteDailyRecordBinding


class WriteDailyRecordFragment : DialogFragment() {

    private var _binding: FragmentWriteDailyRecordBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWriteDailyRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.saveButton.setOnClickListener {
            Toast.makeText(requireActivity(), "Dialog Fragment Dismiss", Toast.LENGTH_LONG).show()
            dialog?.dismiss()
        }
    }


    override fun onResume() {
        super.onResume()
        resizeDialog()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun resizeDialog() {
        val windowManager = requireActivity().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val width: Int = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMatrix = windowManager.currentWindowMetrics
            val insets = windowMatrix.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMatrix.bounds.width() - insets.left - insets.right

        } else {
            val display = windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            size.x
        }

        val layoutParams = dialog?.window?.attributes
        layoutParams?.width = (width * 0.9).toInt()
        dialog?.window?.attributes = layoutParams as WindowManager.LayoutParams
    }
}