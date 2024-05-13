package com.example.nyarubox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class SleepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep)
        val list: MutableList<BarEntry> = mutableListOf()
        for (i in 0 until 10) {
            list.add(BarEntry((i + 1).toFloat(), (Math.random() * 60).toFloat()))
        }
        val bar_chart = findViewById<BarChart>(R.id.sleep_barchart)
        val barDataSet = BarDataSet(list, "睡眠时长")
        val barData = BarData(barDataSet)
        bar_chart.data = barData
        bar_chart.invalidate()
    }
}