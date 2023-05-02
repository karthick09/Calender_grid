package com.example.calender_grid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


@Suppress("DEPRECATION")
class ButtonClickFragment : Fragment() {
    private var rootView: View? = null
    private var textViewDataEntered: TextView? = null
    private var dataEntered: String? = null
    private var fragmentActionListener: FragmentActionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_display, container, false)
        initUI()
        return rootView
    }

    fun setFragmentActionListener(fragmentActionListener: FragmentActionListener?) {
        this.fragmentActionListener = fragmentActionListener
    }
    private fun initUI() {
        textViewDataEntered =
            rootView?.findViewById(R.id.textView1) as TextView
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataEntered = fragmentActionListener?.getMessage()
    }
    override fun onResume() {
        super.onResume()
        textViewDataEntered?.text = dataEntered
    }
}