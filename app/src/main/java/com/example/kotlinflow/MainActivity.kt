package com.example.kotlinflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

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
//
        // cencel flow on lifecycle aware
//        lifecycleScope.launch(Dispatchers.IO) {
//            simpleFlow().collect { user ->
//                Log.d(TAG, "Flow1 $user")
//            }
//        }


        // filter flow
//        lifecycleScope.launch(Dispatchers.IO) {
//            ageList.asFlow()
//                    .filter { age ->
//                        age % 3 == 1
//                    }
//                    .collect { age ->
//                        Log.d(TAG, age.toString())
//                    }
//        }
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            userList.asFlow()
//                    .filter { user ->
//                        user == "user3"
//                    }
//                    .collect { user ->
//                        Log.d(TAG, user)
//                    }
//        }

        // map operator kotlin
//        lifecycleScope.launch(Dispatchers.IO) {
//            ageList.asFlow()
//                    .filter { age ->
//                        age % 3 == 1
//                    }
//                    .map { age ->
//                        "Age: $age"
//                    }
//                    .collect { age ->
//                        Log.d(TAG, age)
//                    }
//        }
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            userList.asFlow()
//                    .filter { user ->
//                        user == "user3"
//                    }
//                    .map { user ->
//                        "Name: $user"
//                    }
//                    .collect { user ->
//                        Log.d(TAG, user)
//                    }
//        }

        // transform operator flow
//        lifecycleScope.launch(Dispatchers.IO) {
//            ageList.asFlow()
//                    .transform { age ->
//                        emit("Age: $age . The value is getting transformed")
//                        emit("Age: $age")
//                    }
//                    .map { age ->
//                        "Age: $age"
//                    }
//                    .collect { age ->
//                        Log.d(TAG, age)
//                    }
//        }

        // take (Size-limiting operators)
//        lifecycleScope.launch(Dispatchers.IO) {
//            ageList.asFlow()
//                    .take(3)
//                    .collect { age ->
//                        Log.d(TAG, age.toString())
//                    }
//        }
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            userList.asFlow()
//                    .take(2)
//                    .collect { user ->
//                        Log.d(TAG, user)
//                    }
//        }


        // Terminal operators reduce
//        lifecycleScope.launch(Dispatchers.IO) {
//            val sum = ageList.asFlow()
//                    .map { age ->
//                        age + 1
//                    }
//                    .reduce { a, b ->
//                        a + b
//                    }
//            Log.d(TAG, sum.toString())
//        }
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            val value = userList.asFlow()
//                    .map { user ->
//                        "$user "
//                    }
//                    .reduce { a, b ->
//                        a + b
//                    }
//            Log.d(TAG, value)
//        }

        // Terminal operators toList
//        lifecycleScope.launch(Dispatchers.IO) {
//            val value = simpleFlow()
//                    .toList()
//            Log.d(TAG, value.toString())
//        }

        // Terminal operators toSet
//        lifecycleScope.launch(Dispatchers.IO) {
//            val value = simpleFlow()
//                    .toSet()
//            Log.d(TAG, value.toString())
//        }

        // Terminal operators first
//        lifecycleScope.launch(Dispatchers.IO) {
//            val value = simpleFlow()
//                    .first()
//            Log.d(TAG, value)
//        }

        // imperative completion
//        lifecycleScope.launch(Dispatchers.IO) {
//            try {
//                ageFlow().collect { value ->
//                    Log.d(TAG, value.toString())
//                }
//            } finally {
//                Log.d(TAG, "Imperative: Flow has completed")
//            }
//        }

        // declarative completion
//        lifecycleScope.launch(Dispatchers.IO) {
//            ageFlow()
//                    .onCompletion {
//                        Log.d(TAG, "Declarative: Flow has completed")
//                    }
//                    .collect { value ->
//                        Log.d(TAG, value.toString())
//                    }
//        }

        // kotlin flowon
//        lifecycleScope.launch {
//            ageFlow()
//                    .onCompletion {
//                        Log.d(TAG, "${Thread.currentThread().name} : Declarative: Flow has completed")
//                    }
//                    .collect { value ->
//                        Log.d(TAG, "${Thread.currentThread().name} $value")
//                    }
//        }
//
//        lifecycleScope.launch {
//            simpleFlow()
//                    .flowOn(Dispatchers.IO)
//                    .onCompletion {
//                        Log.d(TAG, "${Thread.currentThread().name} : Declarative: Flow has completed")
//                    }
//                    .collect { value ->
//                        Log.d(TAG, "${Thread.currentThread().name} $value")
//                    }
//        }

        // Buffer
//        lifecycleScope.launch {
//            val time = measureTimeMillis {
//                numFlow()
//                        .buffer()
//                        .collect {
//                            delay(200)
//                            Log.d(TAG, "Log2: ${Thread.currentThread().name} : $it")
//                        }
//            }
//            Log.d(TAG, "Total Time: $time")
//        }

        // conflate
        lifecycleScope.launch {
            val time = measureTimeMillis {
                numFlow()
                        .conflate()
                        .collect {
                            delay(200)
                            Log.d(TAG, "Log2: ${Thread.currentThread().name} : $it")
                        }
            }
            Log.d(TAG, "Total Time: $time")
        }
    }

    private fun numFlow(): Flow<Int> = flow {
        for (i in 1..10) {
            delay(100)
            Log.d(TAG, "Log1: ${Thread.currentThread().name}")
            emit(i)
        }
    }

    private fun simpleFlow(): Flow<String> = flow {
        userList.forEach { user ->
            Log.d(TAG, Thread.currentThread().name)
            emit(user)
            delay(200)
        }
    }

    private fun ageFlow(): Flow<Int> = ageList.asFlow()
            .transform { age ->
                Log.d(TAG, Thread.currentThread().name)
                if (age == 30) {
                    emit(age + 1)
                } else {
                    emit(age)
                }
            }.flowOn(Dispatchers.IO)

    private companion object {
        const val TAG = "MainActivity"
    }
}
