package com.example.congresotfg.common.database

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class CongresoAPI constructor(context: Context) {

    companion object {

        @Volatile
        private var INSTANCE: CongresoAPI? = null

        fun getInstance(context: Context) = INSTANCE ?: synchronized(this) {

            INSTANCE ?: CongresoAPI(context).also {

                INSTANCE = it

            }

        }

    }

    val requestQueue: RequestQueue by lazy {

        Volley.newRequestQueue(context.applicationContext)

    }

    fun <T> addToRequestQueue(req: Request<T>) {

        requestQueue.add(req)

    }

}