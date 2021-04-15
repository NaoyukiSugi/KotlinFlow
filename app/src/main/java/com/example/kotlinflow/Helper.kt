package com.example.kotlinflow

import kotlinx.coroutines.flow.flowOf

val userList = listOf<String>("user1", "user2", "user3", "user4", "user5")
val ageList = listOf(10, 20, 30, 40, 50)
val flowUserList = flowOf("user6", "user7", "user8", "user9", "user10")
