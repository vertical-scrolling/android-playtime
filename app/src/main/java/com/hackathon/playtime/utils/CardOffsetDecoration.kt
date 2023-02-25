package com.hackathon.playtime.utils

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

val Int.toPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

class CardOffsetDecoration(
    private val vertOffset: Int = 24.toPx,
    private val horOffset: Int = 12.toPx
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(horOffset, vertOffset, horOffset, vertOffset)
    }
}