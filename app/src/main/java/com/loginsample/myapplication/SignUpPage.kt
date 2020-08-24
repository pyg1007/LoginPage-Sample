package com.loginsample.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.loginsample.myapplication.databinding.ActivitySignUpPageBinding
import com.loginsample.myapplication.signup.TermsOfUse

class SignUpPage : AppCompatActivity() {

    private lateinit var signUpPageBinding: ActivitySignUpPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up_page)


        setFragment()
    }

    private fun setFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.SignUpLayout, TermsOfUse()).commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        Intent(this@SignUpPage, LoginPage::class.java).also {
            startActivity(it)
        }
        super.onBackPressed()
    }
}