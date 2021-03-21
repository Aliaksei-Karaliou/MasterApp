package com.github.aliakseikaraliou.masterapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun <T> liveDataOf(
    scope: CoroutineScope,
    context: CoroutineContext = EmptyCoroutineContext,
    callback: suspend () -> T,
): LiveData<Result<out T>> {
    val liveData = MutableLiveData<Result<out T>>()

    scope.launch(context) {
        val result = try {
            val data = callback()
            Result.success(data)
        } catch (t: Throwable) {
            Result.failure<T>(t)
        }

        liveData.postValue(result)
    }

    return liveData
}

fun <T> MediatorLiveData<T>.postOnce(liveData: LiveData<out T>, observer: (T) -> Unit = {}) =
    addSource(liveData) {
        observer(it)
        postValue(it)
        removeSource(liveData)
    }
