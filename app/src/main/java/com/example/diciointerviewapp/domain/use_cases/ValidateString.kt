package com.example.diciointerviewapp.domain.use_cases

import android.util.Patterns

class ValidateString {

    fun execute(text: String) : ValidationResult {
        if(text.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "El campo no debe ser vacío"
            )
        }
        val containsDigits = text.any { !it.isLetter() }
        if (containsDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "El campo sólo debe contener letras"
            )
        }
        return ValidationResult(successful = true)
    }
}