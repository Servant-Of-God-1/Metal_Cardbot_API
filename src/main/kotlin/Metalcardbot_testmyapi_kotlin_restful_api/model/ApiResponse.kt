package Metalcardbot_testmyapi_kotlin_restful_api.model

data class ApiResponse<T>(
    val code: Int,
    val status: String,
    val data: T?
)