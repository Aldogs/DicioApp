package com.example.diciointerviewapp.domain.use_cases

import android.util.Patterns

class ValidateInt {

    fun execute(text: String) : ValidationResult {
        if(text.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "El campo no debe ser vacío"
            )
        }
        val containsLetters = text.any { !it.isDigit() }
        if (containsLetters) {
            return ValidationResult(
                successful = false,
                errorMessage = "El campo sólo debe contener números"
            )
        }
        return ValidationResult(successful = true)
    }
}