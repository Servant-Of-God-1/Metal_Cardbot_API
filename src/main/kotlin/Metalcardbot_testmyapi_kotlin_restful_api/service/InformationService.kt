package Metalcardbot_testmyapi_kotlin_restful_api.service

import Metalcardbot_testmyapi_kotlin_restful_api.model.ApiResponse
import Metalcardbot_testmyapi_kotlin_restful_api.model.Information
import Metalcardbot_testmyapi_kotlin_restful_api.repository.InformationRepository
import org.springframework.stereotype.Service

@Service
class InformationService(private val repository: InformationRepository) {

    fun getById(id: String): ApiResponse<Information> {
        val start = System.currentTimeMillis()
        val info = repository.findById(id)
        val time = System.currentTimeMillis() - start
        return if (info != null) {
            ApiResponse(200, "OK", info, mapOf("responseTime" to "${time}ms"))
        } else {
            ApiResponse(404, "NOT_FOUND", null)
        }
    }

    fun getAll(
        pageSize: Int,
        page: Int,
        category: String?,
        language: String?,
        name: String? = null
    ): ApiResponse<List<Information>> {
        val start = System.currentTimeMillis()
        val data = repository.findAll(page, pageSize, category, language, name)
        val total = repository.count(category, language)
        val pages = (total + pageSize - 1) / pageSize
        val time = System.currentTimeMillis() - start
        return ApiResponse(200, "OK", data, mapOf(
            "page" to page,
            "pageSize" to pageSize,
            "totalItems" to total,
            "totalPages" to pages,
            "hasNextPage" to (page < pages),
            "hasPreviousPage" to (page > 1),
            "responseTime" to "${time}ms"
        ))
    }

    fun getCategories(): ApiResponse<List<Map<String, Any>>> {
        return ApiResponse(200, "OK", repository.getCategories())
    }

    fun getLanguages(): ApiResponse<List<Map<String, Any>>> {
        return ApiResponse(200, "OK", repository.getLanguages())
    }

    fun getStats(): ApiResponse<Map<String, Any>> {
        return ApiResponse(200, "OK", repository.getStats())
    }
}