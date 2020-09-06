package com.loginsample.myapplication.signup

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import com.loginsample.myapplication.R
import com.loginsample.myapplication.SignUpPage
import com.loginsample.myapplication.databinding.FragtermsofuseBinding
import com.loginsample.myapplication.lifeCycleObserveFragment
import com.loginsample.myapplication.viewmodel.SignUpViewModel

class TermsOfUse: Fragment(R.layout.fragtermsofuse) {

    private lateinit var termsOfUseView: View
    private lateinit var termsOfUseContext: Context
    private val termsOfUseDataBinding by lifeCycleObserveFragment { FragtermsofuseBinding.bind(requireView()) }
    private var termsOfUseCheck = false
    private var personalInformationCheck = false
    private var locationInformationCheck = false

    companion object{
        fun newInstance(): TermsOfUse{
            return TermsOfUse()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        termsOfUseContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        termsOfUseView = view
        termsOfUseDataBinding.termsofuse = this@TermsOfUse


        initNextButton()

        setRadioTermsOfUseButton()
        setRadioPersonalInformationButton()
        setRadioLocationInformationButton()
    }

    private fun initNextButton(){
        termsOfUseDataBinding.Next.isEnabled = false
        termsOfUseDataBinding.Next.setBackgroundResource(R.drawable.button_round_disable)
    }

    private fun setNextButton(){

        if (termsOfUseCheck && personalInformationCheck && locationInformationCheck){
            termsOfUseDataBinding.Next.isEnabled = true
            termsOfUseDataBinding.Next.setBackgroundResource(R.drawable.button_round)
        }else{
            termsOfUseDataBinding.Next.isEnabled = false
            termsOfUseDataBinding.Next.setBackgroundResource(R.drawable.button_round_disable)
        }

    }


    override fun onDetach() {
        super.onDetach()
    }

    private fun setRadioTermsOfUseButton(){
        termsOfUseDataBinding.TermsOfUseRadioButton.setOnCheckedChangeListener { _, checkedId ->
            termsOfUseCheck = checkedId == R.id.TermsOfUseAgree
            setNextButton()
        }
    }

    private fun setRadioPersonalInformationButton(){
        termsOfUseDataBinding.PersonalInformationRadioButton.setOnCheckedChangeListener { _, checkedId ->
            personalInformationCheck = checkedId == R.id.PersonalInformationAgree
            setNextButton()
        }
    }

    private fun setRadioLocationInformationButton(){
        termsOfUseDataBinding.LocationInformationRadioButton.setOnCheckedChangeListener { _, checkedId ->
            locationInformationCheck = checkedId == R.id.LocationInformationAgree
            setNextButton()
        }
    }

    fun nextPage(view: View){
        (activity as SignUpPage).replaceFragment(ServiceAgreement.newInstance(), "TermsOfUse")
    }
}