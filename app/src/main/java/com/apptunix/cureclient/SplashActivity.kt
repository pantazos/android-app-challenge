package com.apptunix.cureclient

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apptunix.cureclient.databinding.ActivityMainBinding

/**
 * @author Orestis Pantazos
 * @since 2022-01-07
 * @version 1.0
 */
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        checkOption(sp)

        // read-only button as a first state
        binding.btnContinue.isEnabled = false
        binding.btnContinue.isClickable = false

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            // enable the button in order to click it
            binding.btnContinue.isEnabled = isChecked
        }

        binding.btnContinue.setOnClickListener { rememberOption(sp) }
    }

    private fun rememberOption(prefs: SharedPreferences) {
        val checkBox = binding.checkBox
        if (checkBox.isChecked) {
            with(prefs.edit()) {
                putString("active", "true")
                putString("remember", "true")
                apply()
            }
        } else {
            with(prefs.edit()) {
                putString("active", "true")
                putString("remember", "false")
                apply()
            }
        }
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun checkOption(sp: SharedPreferences) {
        if (sp.getString("active", "") == "true") {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        } else {
            if (sp.getString("remember", "") == "true") {
                // empty
            }
        }
    }

}
