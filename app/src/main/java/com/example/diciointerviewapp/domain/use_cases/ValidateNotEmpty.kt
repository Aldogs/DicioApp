package com.example.diciointerviewapp.domain.use_cases

import android.util.Patterns

class ValidateNotEmpty {

    fun execute(text: String) : ValidationResult {
        if(text.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "El campo no debe ser vacío"
            )
        }

        return ValidationResult(successful = true)
    }
}