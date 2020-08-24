package com.loginsample.myapplication.viewmodel

import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private var termsOfUse: Boolean
        set(value) {
            termsOfUse = value
        }
        get() = this.termsOfUse
    private var serviceAgreement: Boolean
        set(value) {
            serviceAgreement = value
        }
        get() = this.serviceAgreement


    override fun onCleared() {
        super.onCleared()
    }

}