package com.hackathon.playtime.utils

import android.net.Uri
import java.io.File

fun String.toGlidePath() = when {
    startsWith("http") || startsWith("file") -> this
    else -> Uri.fromFile(File(this)).toString()
}