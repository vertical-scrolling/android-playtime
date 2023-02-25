package com.hackathon.playtime.utils

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityViewBindingDelegate<V : ViewBinding>(
    private val factory: (LayoutInflater) -> V
) : ReadOnlyProperty<Activity, V> {

    private var binding: V? = null

    override fun getValue(thisRef: Activity, property: KProperty<*>): V {
        return binding ?: factory(thisRef.layoutInflater).also {
            thisRef.setContentView(it.root)
            binding = it
        }
    }
}

fun <V : ViewBinding> Activity.viewBinding(factory: (LayoutInflater) -> V) =
    ActivityViewBindingDelegate(factory)