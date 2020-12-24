package com.okellosoftwarez.popularmovies

import android.app.Application
import androidx.room.Room
import com.okellosoftwarez.popularmovies.ui.notifications.MovieDB

//class kotlinSample {
    class kotlinSample : Application() {
        companion object {
            @JvmField
            var databaseInstance: MovieDB? = null
//        var databaseInstance: MovieDB? = null
//        var databaseInstance: MovieDB? = null

        }

        override fun onCreate() {
            super.onCreate()
            databaseInstance = Room.databaseBuilder(applicationContext, MovieDB::class.java, "Movies_DB").fallbackToDestructiveMigration().build();
        }
    }
//}