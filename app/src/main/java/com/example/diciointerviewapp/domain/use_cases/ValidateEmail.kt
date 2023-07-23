package com.example.diciointerviewapp.domain.use_cases

import android.util.Patterns

class ValidateEmail {

    fun execute(email: String) : ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "El email no debe ser vacío"
            )
        }
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Escribe un email válido"
            )
        }
        return ValidationResult(successful = true)
    }
}