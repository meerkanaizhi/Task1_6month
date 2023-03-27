package com.example.task1_6month


    import android.app.Activity
    import android.content.Intent
    import android.os.Bundle
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import com.example.task1_6month.MainActivity.Companion.TEXT_1
    import com.example.task1_6month.databinding.SecondActivityBinding


class ActivitySecond : AppCompatActivity() {
        private lateinit var binding: SecondActivityBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = SecondActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)
            initView()
            initClickers()

        }


        private fun initClickers() {
            with(binding) {
                btnReturn.setOnClickListener {
                    val data2 = binding.edSecond.text
                    if (data2 == null || data2.toString() == "") {
                        Toast.makeText(
                            this@ActivitySecond,
                            "Заполните!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val intent = Intent()
                        intent.putExtra(TEXT_2, binding.edSecond.text.toString())
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }
                }
            }
        }

        private fun initView() {
            val text = intent.getStringExtra(TEXT_1)
            binding.edSecond.setText(text)
        }

        companion object {
            const val TEXT_2 = "text_2"
        }
    }
