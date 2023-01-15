package com.elsonji.coworks.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun <T> Fragment.observe(liveData: LiveData<T?>, callback: (result: T?) -> Unit) {
    liveData.observe(viewLifecycleOwner) {
        callback.invoke(it)
    }
}

fun <T> Fragment.observeNotNull(liveData: LiveData<T>, callback: (result: T) -> Unit) {
    liveData.observe(viewLifecycleOwner) {
        if (null != it) {
            callback.invoke(it)
        }
    }
}
