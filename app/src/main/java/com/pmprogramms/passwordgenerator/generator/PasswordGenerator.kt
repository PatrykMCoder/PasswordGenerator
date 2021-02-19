package com.pmprogramms.passwordgenerator.generator

import android.util.Log
import java.lang.StringBuilder
import java.util.*

class PasswordGenerator(
    private val lenPassword: Int
) {
    private val random = Random()
    private var alphabetBig = "ABCDEFGHIKLMNOPQRSTVXYZ"
    private var alphabetSmall = alphabetBig.toLowerCase(Locale.ROOT)
    private var specialCharacters = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"
    private var numbers = "1234567890"
    private var password = ""
    private lateinit var passwordBuilder: StringBuilder

    fun generatePassword(): String {
        for (i in 0 until lenPassword) {
            passwordBuilder = StringBuilder(password)
            var randomNumber = random.nextInt(4 - 1) + 1
            when (randomNumber) {
                1 -> {
                    randomNumber = random.nextInt(alphabetBig.length - 1) + 1
                    password = passwordBuilder.append(alphabetBig[randomNumber]).toString()
                }
                2 -> {
                    randomNumber = random.nextInt(alphabetSmall.length - 1) + 1
                    password = passwordBuilder.append(alphabetSmall[randomNumber]).toString()
                }
                3 -> {
                    randomNumber =
                        random.nextInt(specialCharacters.length - 1) + 1
                    password = passwordBuilder.append(specialCharacters[randomNumber]).toString()
                }
                4 -> {
                    randomNumber = random.nextInt(numbers.length - 1) + numbers.length
                    password = passwordBuilder.append(specialCharacters[randomNumber]).toString()
                }
                else -> {
                    password = passwordBuilder.append(" ").toString()
                }
            }
        }

        return password
    }
}