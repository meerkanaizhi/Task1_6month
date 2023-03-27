package com.example.task1_6month

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.app.Activity
import android.content.Intent

import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

import com.example.task1_6month.ActivitySecond.Companion.TEXT_2
import com.example.task1_6month.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()

    }

    private fun initClickers() {
        registerForActivity()
        with(binding) {
            btnGo.setOnClickListener {
                val data = binding.et.text
                if (data == null || data.toString() == "") {
                    Toast.makeText(
                        this@MainActivity,
                        "Заполните!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent(this@MainActivity, ActivitySecond::class.java)
                    intent.putExtra(TEXT_1, et.text.toString())
                    resultLauncher.launch(intent)

                }
            }
        }
    }



    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                if (activityResult.resultCode == Activity.RESULT_OK && activityResult.data != null) {
                    binding.et.setText(activityResult.data!!.getStringExtra(TEXT_2))
                }
            }

    }

    companion object {
        const val RESULT_FOR_MA = "TextBox"
        const val TEXT_1 = "text_1"
    }
}