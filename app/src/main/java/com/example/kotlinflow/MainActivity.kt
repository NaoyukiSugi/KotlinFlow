package com.example.kotlinflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.IO).launch {
//
//            launch {
//                simpleFlow().collect { user ->
//                    Log.d(TAG, "Flow1 $user")
//                }
//            }
//
//            launch {
//                simpleFlow().collect { user ->
//                    Log.d(TAG, "Flow2 $user")
//                }
//            }
//
//            launch {
//                simpleFlow().collect { user ->
//                    Log.d(TAG, "Flow3 $user")
//                }
//            }
//        }

        CoroutineScope(Dispatchers.IO).launch {
            launch {
                flowUserList.collect { user ->
                    Log.d(TAG, "Flow1 $user")
                    delay(500)
                }
            }

            launch {
                userList.asFlow().collect { user ->
                    Log.d(TAG, "Flow2 $user")
                    delay(500)
                }
            }
        }

    }

    private fun simpleFlow(): Flow<String> = flow {
        userList.forEach { user ->
            emit(user)
            delay(500)
        }
    }

    private companion object {
        const val TAG = "MainActivity"
    }
}
