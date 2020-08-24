package com.loginsample.myapplication.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.loginsample.myapplication.R
import com.loginsample.myapplication.databinding.FragtermsofuseBinding

class TermsOfUse: Fragment() {

    private lateinit var termsOfUseView: View
    private lateinit var termsOfUseContext: Context
    private lateinit var termsOfUseDataBinding: FragtermsofuseBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        termsOfUseContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        termsOfUseView = view
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        termsOfUseDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragtermsofuse, container, false)
        return termsOfUseDataBinding.root
    }

    override fun onDetach() {
        super.onDetach()
    }
}