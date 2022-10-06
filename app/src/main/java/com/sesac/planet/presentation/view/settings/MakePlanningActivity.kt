package com.sesac.planet.presentation.view.settings

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sesac.planet.R
import com.sesac.planet.utility.SystemUtility

class MakePlanningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_planning)

        initialize()
    }

    private fun initialize() {
        SystemUtility.setLightStatusBar(window, Color.WHITE)
    }


}