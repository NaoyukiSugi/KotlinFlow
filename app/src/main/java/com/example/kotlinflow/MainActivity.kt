package com.example.kotlinflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //suspend fun to print user list
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

        // flow builder
//        CoroutineScope(Dispatchers.IO).launch {
//            launch {
//                flowUserList.collect { user ->
//                    Log.d(TAG, "Flow1 $user")
//                    delay(500)
//                }
//            }
//
//            launch {
//                userList.asFlow().collect { user ->
//                    Log.d(TAG, "Flow2 $user")
//                    delay(500)
//                }
//            }
//        }

        // cancel flow
//        CoroutineScope(Dispatchers.IO).launch {
//            launch {
//                withTimeoutOrNull(5000) {
//                    simpleFlow().collect { user ->
//                        Log.d(TAG, "Flow1 $user")
//                    }
//                }

//                simpleFlow().collect { user ->
//                    Log.d(TAG, "Flow1 $user")
//                }
//            }
//        }

        // cencel flow on lifecycle aware
//        lifecycleScope.launch(Dispatchers.IO) {
//            simpleFlow().collect { user ->
//                Log.d(TAG, "Flow1 $user")
//            }
//        }


        // filter flow
        lifecycleScope.launch(Dispatchers.IO) {
            ageList.asFlow()
                    .filter { age ->
                        age % 3 == 1
                    }
                    .collect { age ->
                        Log.d(TAG, age.toString())
                    }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            userList.asFlow()
                    .filter { user ->
                        user == "user3"
                    }
                    .collect { user ->
                        Log.d(TAG, user)
                    }
        }


    }

    private fun simpleFlow(): Flow<String> = flow {
        userList.forEach { user ->
            emit(user)
            delay(2000)
        }
    }

    private companion object {
        const val TAG = "MainActivity"
    }
}
