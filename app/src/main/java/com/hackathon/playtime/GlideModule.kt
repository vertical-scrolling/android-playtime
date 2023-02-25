package com.hackathon.playtime

import android.content.Context
import android.os.Handler
import android.util.Log
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import okhttp3.OkHttpClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.InputStream

@GlideExtension
class GlideModule: AppGlideModule(), KoinComponent  {

    private val client: OkHttpClient by inject(named("client"))

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(client))
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        if (BuildConfig.DEBUG) {
            builder.setLogLevel(Log.DEBUG)
        }

        builder.setDefaultRequestOptions(
                RequestOptions().placeholder(CircularProgressDrawable(context).apply {
                    setColorSchemeColors(R.color.green_main_dark, R.color.green_shadow_dark, R.color.white_main_dark)
                    centerRadius = 30f
                    strokeWidth = 5f
                    Handler().post { start() }
                })
        )
        super.applyOptions(context, builder)
    }
}