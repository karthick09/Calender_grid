package com.example.calender_grid

interface FragmentActionListener {
    fun onMonthsSelected(month: String?)
    fun addDayDescription()
    fun getMessage(): String

    companion object {
        const val KEY_SELECTED_MONTHS = "KEY_SELECTED_MONTHS"
    }
}