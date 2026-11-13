package com.example.navigationlab.data.remote

import com.example.navigationlab.data.remote.dto.UserDto

class StudentRemoteDataSource(
    private val api: StudentApiService
) {
    suspend fun getStudents(): List<UserDto> {
        return api.getUsers().users
    }

    suspend fun getStudent(id: Int): UserDto {
        return api.getUser(id)
    }

    suspend fun searchStudents(query: String): List<UserDto> {
        return api.searchUsers(query).users
    }
}
