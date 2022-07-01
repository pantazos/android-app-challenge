package com.apptunix.cureclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apptunix.cureclient.databinding.ActivityHomeBinding

/**
 * @author Orestis Pantazos
 * @since 2022-01-07
 * @version 1.0
 */
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // view binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
