package com.pmprogramms.passwordgenerator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pmprogramms.passwordgenerator.databinding.ActivityMainBinding
import com.pmprogramms.passwordgenerator.generator.PasswordGenerator
import com.pmprogramms.passwordgenerator.util.TextHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonGeneratePassword.setOnClickListener {
            if (TextHelper().checkInputs(binding.textLengthPassword.text.toString())) {
                binding.textPasswordGenerated.text = PasswordGenerator(
                    binding.textLengthPassword.text.toString().toInt()
                ).generatePassword()
            } else
                Toast.makeText(
                    applicationContext,
                    "Please enter length of password[between 8 and 100]",
                    Toast.LENGTH_SHORT
                ).show()
        }

        binding.buttonCopyPassword.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip =
                ClipData.newPlainText("password", binding.textPasswordGenerated.text.toString())
            clipboard.setPrimaryClip(clip)
            Toast.makeText(
                applicationContext,
                "Copied to clipboard",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}