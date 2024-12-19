package com.example.inappdemo

import android.app.Application
import com.moengage.core.DataCenter
import com.moengage.core.LogLevel
import com.moengage.core.MoEngage
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig
import com.moengage.core.config.MoEngageEnvironmentConfig
import com.moengage.core.config.NotificationConfig
import com.moengage.core.model.environment.MoEngageEnvironment

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        moEngage = MoEngage.Builder(this, "Z1UDNSWJALFR3UTPWWMCSF5Z", DataCenter.DATA_CENTER_1)
            .configureLogs(LogConfig(LogLevel.VERBOSE, true)).configureNotificationMetaData(
                NotificationConfig(
                    R.drawable.ic_launcher_foreground,
                    R.drawable.ic_launcher_foreground
                )
            )
            .configureMoEngageEnvironment(MoEngageEnvironmentConfig(MoEngageEnvironment.TEST))
            .configureFcm(FcmConfig(true))
            .build()


        MoEngage.initialiseDefaultInstance(moEngage)
    }

    companion object {
        lateinit var moEngage: MoEngage
    }

}