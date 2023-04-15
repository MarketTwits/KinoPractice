package com.example.kinopractice.presentation.utils

interface InputStringValidation {
    fun validate(inputString: String): Boolean
    class Base : InputStringValidation {
        override fun validate(inputString: String): Boolean {
            return inputString.length < 3
        }
    }
}

