package com.alodokter.learncollab

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.alodokter.learncollab.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val inputEmail = binding.edtEmail.text.toString().trim()

                when {
                    inputEmail.isEmpty() -> {
                        binding.tilEmail.error = "Email can't be empty"
                    }
                    Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches() -> {
                        binding.tilEmail.isErrorEnabled = false
                    }
                    else -> {
                        binding.tilEmail.error = "Invalid email"
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val inputPassword = binding.edtPassword.text.toString().trim()

                when {
                    inputPassword.isEmpty() -> binding.tilPassword.error = "Password can't be empty"
                    inputPassword.length < 8 -> binding.tilPassword.error =
                        "Password minimum length is 8"
                    else -> binding.tilPassword.isErrorEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}