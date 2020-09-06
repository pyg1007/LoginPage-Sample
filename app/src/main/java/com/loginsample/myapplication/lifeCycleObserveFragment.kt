package com.loginsample.myapplication

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T> Fragment.lifeCycleObserveFragment(initialise: () -> T) : ReadOnlyProperty<Fragment, T> = object : ReadOnlyProperty<Fragment, T>,
    DefaultLifecycleObserver {

    private var binding: T? = null

    private var viewLifecycleOwner: LifecycleOwner? = null

    init {
        this@lifeCycleObserveFragment.viewLifecycleOwnerLiveData.observe(this@lifeCycleObserveFragment, Observer {
            viewLifecycleOwner?.lifecycle?.removeObserver(this)

            viewLifecycleOwner = it.also {
                it.lifecycle.addObserver(this)
            }
        })
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        binding = null
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return this.binding?: initialise().also {
            this.binding = it
        }
    }
}