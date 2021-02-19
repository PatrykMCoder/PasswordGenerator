package com.pmprogramms.passwordgenerator.util

class TextHelper {
    fun checkInputs(value: String?): Boolean {
        return value != null && value != "" && (value.toInt() in 8..100)
    }
}