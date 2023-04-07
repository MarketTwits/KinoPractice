package com.example.kinopractice.domain

interface NetworkResult {
    fun isSuccess(): Boolean
    fun errorMessage(): String

    class Success<T>(private val data: T) : NetworkResult {
         override fun isSuccess(): Boolean = true
         override fun errorMessage(): String = ""
         fun getData() : T = data
    }

    class Failure(private val error: String) : NetworkResult {
         override fun isSuccess(): Boolean = false
         override fun errorMessage(): String = error
    }
}