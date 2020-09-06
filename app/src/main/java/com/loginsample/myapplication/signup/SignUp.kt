package com.loginsample.myapplication.signup

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.loginsample.myapplication.R
import com.loginsample.myapplication.databinding.FragsignupBinding
import com.loginsample.myapplication.lifeCycleObserveFragment

class SignUp: Fragment(R.layout.fragsignup) {

    private val signUpDataBinding by lifeCycleObserveFragment { FragsignupBinding.bind(requireView()) }
    private lateinit var signUpView: View
    private lateinit var signUpContext: Context

    companion object{
        fun newInstance(): SignUp{
            return SignUp()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        signUpContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpView = view

        setHiddenSoftKeyboard()
        setSpinner()
    }

    private fun setSpinner(){
        signUpDataBinding.Month.onItemSelectedListener = spinnerListener
    }

    private val spinnerListener = object: AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            Log.e("set", parent?.getItemIdAtPosition(position).toString())
        }
    }

    private fun setHiddenSoftKeyboard(){
        signUpDataBinding.ParentLayout.setOnClickListener {
            val imm = signUpContext.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}