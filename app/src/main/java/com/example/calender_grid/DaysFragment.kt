package com.example.calender_grid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

@Suppress("DEPRECATION")
class DaysFragment:Fragment() {
    private var rootView: View? = null
    private lateinit var listViewMonthDescription: GridView
    private var daysAdapter: ArrayAdapter<String>? = null
    private var monthName: String? = null
    private var monthDescription = ArrayList<String>()
    private var fragmentActionListener: FragmentActionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_month_decription, container, false)
        initUI()
        return rootView
    }
    private fun initUI() {
        listViewMonthDescription = rootView?.findViewById(R.id.GridView) as GridView
        daysAdapter=ArrayAdapter(requireContext(), R.layout.custom_list_item_set, monthDescription)
        listViewMonthDescription.adapter = daysAdapter
        listViewMonthDescription.onItemClickListener=
            AdapterView.OnItemClickListener{ _,_,_,_ ->
                fragmentActionListener?.addDayDescription()
        }
    }
    fun setFragmentActionListener(fragmentActionListener: FragmentActionListener?) {
        this.fragmentActionListener = fragmentActionListener
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.title = monthName
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle: Bundle? = arguments
        monthName = bundle?.getString(FragmentActionListener.KEY_SELECTED_MONTHS, "Jan")
        generateDays(daysOfMonth(monthName),monthDescription)
    }

    private fun daysOfMonth(month : String?): Int{
        return when(month){
            "Jan","Mar","May","July","Aug","Oct","Dec" -> 31
            "Feb" -> 28
            else -> 30
        }
    }


    private fun generateDays(i:Int, data: ArrayList<String>){
        for(i in 1..i) {
            data.add(i.toString())
        }

    }
}