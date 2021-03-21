package com.github.aliakseikaraliou.masterapp.utils

class Result<T> private constructor(
    private val _data: T?,
    private val _throwable: Throwable?,
) {

    fun get() = _data
        ?: throw InvalidResultException("Data is empty because failure ${_throwable!!::class.java.name} is thrown")

    fun getOrNull() = _data

    fun exception() = _throwable
        ?: throw InvalidResultException("Exception is empty because data is loaded")

    fun exceptionOrNull() = _throwable

    val isSucceed
        get() = _throwable == null

    companion object {

        fun <T> success(item: T) = Result(item, null)

        fun <T> failure(exception: Throwable) = Result(null, exception)
    }

    class InvalidResultException(override val message: String) : Exception(message)
}