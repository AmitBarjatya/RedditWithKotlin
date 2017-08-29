package com.amit.redditwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if(savedInstanceState == null){
//            changeFragment(new NewsFragment())
        }
    }

    fun changeFragment(fragment: Fragment, cleanStack:Boolean = false){
        val transactionManager = supportFragmentManager.beginTransaction()
        if (cleanStack){
            clearBackStack()
        }
        transactionManager.setCustomAnimations(
                R.anim.abc_fade_in,R.anim.abc_fade_out,R.anim.abc_popup_enter,R.anim.abc_popup_exit)
        transactionManager.replace(R.id.activity_base_content,fragment)
        transactionManager.addToBackStack(null)
        transactionManager.commit()

    }

    fun clearBackStack(){
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0){
            manager.popBackStack(manager.getBackStackEntryAt(0).id,FragmentManager.POP_BACK_STACK_INCLUSIVE)

        }
    }

    override fun onBackPressed() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 1){
            manager.popBackStackImmediate()
        }else
            finish()
    }
}
