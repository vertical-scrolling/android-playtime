package com.hackathon.playtime

import android.os.Bundle
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val stateMap = HashMap<String, Bundle?>()

    fun saveState(tag: String, bundle: Bundle?) {
        stateMap[tag] = bundle
    }

    fun getState(tag: String) = stateMap.remove(tag)
}