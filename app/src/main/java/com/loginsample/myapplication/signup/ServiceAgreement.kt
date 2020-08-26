package com.loginsample.myapplication.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.loginsample.myapplication.R
import com.loginsample.myapplication.SignUpPage
import com.loginsample.myapplication.databinding.FragserviceagreementBinding

class ServiceAgreement : Fragment(){

    private lateinit var serviceAgreementDataBinding: FragserviceagreementBinding
    private lateinit var serviceAgreementContext: Context
    private lateinit var serviceAgreementView: View

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
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        serviceAgreementDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragserviceagreement, container, false)
        return serviceAgreementDataBinding.root
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun nextPage(view: View){
        (activity as SignUpPage).replaceFragment(SignUp.newInstance(), "TermsOfUse")
    }
}