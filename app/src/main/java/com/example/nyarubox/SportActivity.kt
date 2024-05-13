package com.example.nyarubox

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.nyarubox.databinding.ActivitySportBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class SportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)


            val list: MutableList<BarEntry> = mutableListOf()
            for (i in 0 until 10) {
                list.add(BarEntry((i + 1).toFloat(), (Math.random() * 60).toFloat()))
            }
            val bar_chart = findViewById<BarChart>(R.id.record_barchart)
            val barDataSet = BarDataSet(list, "时长")
            val barData = BarData(barDataSet)
            bar_chart.data = barData
            bar_chart.invalidate()


    }
}