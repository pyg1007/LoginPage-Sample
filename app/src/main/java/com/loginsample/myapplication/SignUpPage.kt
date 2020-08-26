package com.loginsample.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
        supportFragmentManager.beginTransaction().add(R.id.SignUpLayout, TermsOfUse.newInstance()).commit()
    }

    fun replaceFragment(fragment: Fragment, name: String){
        supportFragmentManager.beginTransaction().replace(R.id.SignUpLayout, fragment).addToBackStack(name).commit()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStack()
        }else {
            Intent(this@SignUpPage, LoginPage::class.java).also {
                startActivity(it)
            }
            super.onBackPressed()
        }
    }
}