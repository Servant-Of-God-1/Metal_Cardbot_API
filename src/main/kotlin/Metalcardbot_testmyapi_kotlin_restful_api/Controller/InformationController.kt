package Metalcardbot_testmyapi_kotlin_restful_api.Controller

import Metalcardbot_testmyapi_kotlin_restful_api.model.ApiResponse
import Metalcardbot_testmyapi_kotlin_restful_api.model.Information
import Metalcardbot_testmyapi_kotlin_restful_api.service.InformationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class InformationController(private val service: InformationService) {

    /**
     * GET Full Information by ID
     * GET /api/information/{id}
     */
    @GetMapping("/information/{id}")
    fun getInformation(@PathVariable("id") id: String): ResponseEntity<ApiResponse<Information>> {
        val response = service.getById(id)
        return if (response.code == 200) ResponseEntity.ok(response)
        else ResponseEntity.status(response.code).body(response)
    }

    /**
     * LIST Information with Pagination, Category & Language Filter
     * GET /api/information?pageSize=10&page=1&category=teknologi&language=id
     */
    @GetMapping("/information")
    fun listInformation(
        @RequestParam(defaultValue = "10") pageSize: Int,
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(required = false) category: String?,
        @RequestParam(required = false) language: String?
    ): ResponseEntity<ApiResponse<List<Information>>> {
        if (pageSize < 1 || page < 1) {
            return ResponseEntity.status(400).body(
                ApiResponse(400, "BAD_REQUEST - pageSize and page must be greater than 0", null)
            )
        }
        if (pageSize > 50) {
            return ResponseEntity.status(400).body(
                ApiResponse(400, "BAD_REQUEST - pageSize cannot exceed 50", null)
            )
        }

        val response = service.getAll(pageSize, page, category, language)
        return ResponseEntity.ok(response)
    }

    /**
     * GET Image Only
     * GET /api/information/{id}/image
     */
    @GetMapping("/information/{id}/image")
    fun getImageOnly(@PathVariable("id") id: String): ResponseEntity<ApiResponse<Map<String, String>>> {
        val info = service.getById(id)
        return if (info.code == 200 && info.data != null) {
            val imageData = mapOf(
                "id" to info.data.id,
                "name" to info.data.name,
                "image" to info.data.Image,
                "category" to info.data.category,
                "language" to info.data.language
            )
            ResponseEntity.ok(ApiResponse(200, "OK", imageData))
        } else {
            ResponseEntity.status(404).body(ApiResponse(404, "NOT_FOUND", null))
        }
    }

    /**
     * GET Video Only
     * GET /api/information/{id}/video
     */
    @GetMapping("/information/{id}/video")
    fun getVideoOnly(@PathVariable("id") id: String): ResponseEntity<ApiResponse<Map<String, String>>> {
        val info = service.getById(id)
        return if (info.code == 200 && info.data != null) {
            val videoData = mapOf(
                "id" to info.data.id,
                "name" to info.data.name,
                "video" to info.data.Url_Video,
                "category" to info.data.category,
                "language" to info.data.language
            )
            ResponseEntity.ok(ApiResponse(200, "OK", videoData))
        } else {
            ResponseEntity.status(404).body(ApiResponse(404, "NOT_FOUND", null))
        }
    }

    /**
     * GET Detail Only (Text)
     * GET /api/information/{id}/detail
     */
    @GetMapping("/information/{id}/detail")
    fun getDetailOnly(@PathVariable("id") id: String): ResponseEntity<ApiResponse<Map<String, String>>> {
        val info = service.getById(id)
        return if (info.code == 200 && info.data != null) {
            val detailData = mapOf(
                "id" to info.data.id,
                "name" to info.data.name,
                "description" to info.data.Description,
                "category" to info.data.category,
                "language" to info.data.language
            )
            ResponseEntity.ok(ApiResponse(200, "OK", detailData))
        } else {
            ResponseEntity.status(404).body(ApiResponse(404, "NOT_FOUND", null))
        }
    }

    /**
     * GET All Images by Category & Language
     * GET /api/information/images?category=teknologi&language=id
     */
    @GetMapping("/information/images")
    fun getAllImages(
        @RequestParam(required = false) category: String?,
        @RequestParam(required = false) language: String?
    ): ResponseEntity<ApiResponse<List<Map<String, String>>>> {
        val infoList = service.getAll(50, 1, category, language)
        return if (infoList.code == 200 && infoList.data != null) {
            val images = infoList.data.map { info ->
                mapOf(
                    "id" to info.id,
                    "name" to info.name,
                    "image" to info.Image,
                    "category" to info.category,
                    "language" to info.language
                )
            }
            ResponseEntity.ok(ApiResponse(200, "OK", images))
        } else {
            ResponseEntity.status(500).body(ApiResponse(500, "ERROR", null))
        }
    }

    /**
     * GET All Videos by Category & Language
     * GET /api/information/videos?category=teknologi&language=id
     */
    @GetMapping("/information/videos")
    fun getAllVideos(
        @RequestParam(required = false) category: String?,
        @RequestParam(required = false) language: String?
    ): ResponseEntity<ApiResponse<List<Map<String, String>>>> {
        val infoList = service.getAll(50, 1, category, language)
        return if (infoList.code == 200 && infoList.data != null) {
            val videos = infoList.data.map { info ->
                mapOf(
                    "id" to info.id,
                    "name" to info.name,
                    "video" to info.Url_Video,
                    "category" to info.category,
                    "language" to info.language
                )
            }
            ResponseEntity.ok(ApiResponse(200, "OK", videos))
        } else {
            ResponseEntity.status(500).body(ApiResponse(500, "ERROR", null))
        }
    }

    /**
     * GET All Categories
     * GET /api/categories
     */
    @GetMapping("/categories")
    fun getCategories(): ResponseEntity<ApiResponse<List<Map<String, Any>>>> {
        return ResponseEntity.ok(service.getCategories())
    }

    /**
     * GET All Languages
     * GET /api/languages
     */
    @GetMapping("/languages")
    fun getLanguages(): ResponseEntity<ApiResponse<List<Map<String, Any>>>> {
        return ResponseEntity.ok(service.getLanguages())
    }
}