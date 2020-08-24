package com.loginsample.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.loginsample.myapplication.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {

    private lateinit var loginDataBinding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_page)
        loginDataBinding.activity = this@LoginPage
    }

    fun moveLogin(){

    }

    fun moveSignUpPage(view: View){
        Intent(this@LoginPage, SignUpPage::class.java).also {
            startActivity(it)
            finish()
        }
    }
}