package Metalcardbot_testmyapi_kotlin_restful_api.service

import Metalcardbot_testmyapi_kotlin_restful_api.model.ApiResponse
import Metalcardbot_testmyapi_kotlin_restful_api.model.Information
import Metalcardbot_testmyapi_kotlin_restful_api.repository.InformationRepository
import org.springframework.stereotype.Service

@Service
class InformationService(private val repository: InformationRepository) {

    fun getById(id: String): ApiResponse<Information> {
        return try {
            val information = repository.findById(id)
            if (information != null) {
                ApiResponse(200, "OK", information)
            } else {
                ApiResponse(404, "NOT_FOUND", null)
            }
        } catch (e: Exception) {
            ApiResponse(500, "INTERNAL_SERVER_ERROR", null)
        }
    }

    fun getAll(pageSize: Int, page: Int, category: String? = null, language: String? = null): ApiResponse<List<Information>> {
        return try {
            val data = repository.findAll(page, pageSize, category, language)
            val totalItems = repository.count(category, language)
            val totalPages = (totalItems + pageSize - 1) / pageSize

            ApiResponse(
                code = 200,
                status = "OK - Page $page of $totalPages | ${data.size} of $totalItems items",
                data = data
            )
        } catch (e: Exception) {
            ApiResponse(500, "INTERNAL_SERVER_ERROR", emptyList())
        }
    }

    fun getCategories(): ApiResponse<List<Map<String, Any>>> {
        return try {
            ApiResponse(200, "OK", repository.getCategories())
        } catch (e: Exception) {
            ApiResponse(500, "INTERNAL_SERVER_ERROR", emptyList())
        }
    }

    fun getLanguages(): ApiResponse<List<Map<String, Any>>> {
        return try {
            ApiResponse(200, "OK", repository.getLanguages())
        } catch (e: Exception) {
            ApiResponse(500, "INTERNAL_SERVER_ERROR", emptyList())
        }
    }
}