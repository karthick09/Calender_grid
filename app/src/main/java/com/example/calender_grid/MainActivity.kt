package com.example.calender_grid

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(),FragmentActionListener {
    var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        addMonths()
    }
    private fun addMonths(){
        fragmentTransaction = fragmentManager?.beginTransaction()
        val monthsListFragment = MonthFragment()
        monthsListFragment.setFragmentActionListener(this)
        fragmentTransaction!!.add(R.id.fragmentContainer,monthsListFragment)
        fragmentTransaction!!.commit()
    }
    private fun addMonthDescription(monthsName : String?){
        fragmentTransaction = fragmentManager?.beginTransaction()
        val monthDescriptionFragment = DaysFragment()
        monthDescriptionFragment.setFragmentActionListener(this)
        val bundle = Bundle()
        bundle.putString(FragmentActionListener.KEY_SELECTED_MONTHS, monthsName)
        monthDescriptionFragment.setArguments(bundle)
        fragmentTransaction!!.add(R.id.fragmentContainer, monthDescriptionFragment)
        fragmentTransaction!!.addToBackStack(null)
        fragmentTransaction!!.commit()
    }
    override fun onMonthsSelected(month: String?) {
        addMonthDescription(month)
    }

    override fun addDayDescription() {
        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, dayDecripiton())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    override fun getMessage(): String {
        val simpleEditText = findViewById<View>(R.id.textViewDayDescription) as EditText
        return simpleEditText.text.toString()
    }

    fun buttonClick(view :View){
        fragmentTransaction = fragmentManager?.beginTransaction()
        val data =ButtonClickFragment()
        data.setFragmentActionListener(this)
        fragmentTransaction!!.add(R.id.fragmentContainer, data)
        fragmentTransaction!!.addToBackStack(null)
        fragmentTransaction!!.commit()
    }

}
