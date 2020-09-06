package com.loginsample.myapplication.signup

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.loginsample.myapplication.R
import com.loginsample.myapplication.SignUpPage
import com.loginsample.myapplication.databinding.FragserviceagreementBinding
import com.loginsample.myapplication.lifeCycleObserveFragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ServiceAgreement : Fragment(R.layout.fragserviceagreement){

    private val serviceAgreementDataBinding by lifeCycleObserveFragment{ FragserviceagreementBinding.bind(requireView()) }
    private lateinit var serviceAgreementContext: Context
    private lateinit var serviceAgreementView: View
    private var serviceAgreementCheck = false

    companion object{
        fun newInstance(): ServiceAgreement{
            return ServiceAgreement()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        serviceAgreementContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        serviceAgreementView = view

        serviceAgreementDataBinding.serviceAgreement = this@ServiceAgreement

        serviceAgreementDataBinding.Next.isEnabled = false
        serviceAgreementDataBinding.Next.setBackgroundResource(R.drawable.button_round_disable)

        setServiceAgreement()
    }

    private fun setServiceAgreement(){
        serviceAgreementDataBinding.serviceAgreementRadioButton.setOnCheckedChangeListener { _, checkedId ->
            serviceAgreementCheck = checkedId == R.id.serviceAgreementAgree
            setNextButton()
        }
    }

    private fun setNextButton(){
        if (serviceAgreementCheck) {
            serviceAgreementDataBinding.Next.isEnabled = true
            serviceAgreementDataBinding.Next.setBackgroundResource(R.drawable.button_round)
        }else{
            serviceAgreementDataBinding.Next.isEnabled = false
            serviceAgreementDataBinding.Next.setBackgroundResource(R.drawable.button_round_disable)
        }
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun nextPage(view: View){
        (activity as SignUpPage).replaceFragment(SignUp.newInstance(), "TermsOfUse")
    }
}