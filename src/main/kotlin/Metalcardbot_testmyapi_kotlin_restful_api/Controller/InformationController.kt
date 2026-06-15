package Metalcardbot_testmyapi_kotlin_restful_api.controller

import Metalcardbot_testmyapi_kotlin_restful_api.model.Information
import Metalcardbot_testmyapi_kotlin_restful_api.service.InformationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class InformationController(private val service: InformationService) {

    @GetMapping("/information")
    fun listInformation(
        @RequestParam(defaultValue = "20") limit: Int,
        @RequestParam(defaultValue = "0") offset: Int,
        @RequestParam(required = false) category: String?,
        @RequestParam(required = false) language: String?,
        @RequestParam(required = false) name: String?
    ): ResponseEntity<List<Information>> {
        if (limit < 1 || limit > 50) {
            return ResponseEntity.status(400).body(emptyList())
        }

        val page = offset / limit + 1
        val response = service.getAll(limit, page, category, language, name)
        val data = response.data ?: emptyList()
        val metadata = response.metadata

        return ResponseEntity.ok()
            .header("Cache-Control", "public, max-age=300, s-maxage=3600")
            .header("X-Total-Count", metadata?.get("totalItems").toString())
            .body(data)
    }

    @GetMapping("/information/{id}")
    fun getInformation(
        @PathVariable("id") id: String
    ): ResponseEntity<Information> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok()
                .header("Cache-Control", "public, max-age=3600, s-maxage=86400")
                .body(response.data)
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/image")
    fun getImageOnly(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("image" to response.data.Image))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/image1")
    fun getImage1Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("image1" to response.data.Image1))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/image2")
    fun getImage2Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("image2" to response.data.Image2))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/image3")
    fun getImage3Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("image3" to response.data.Image3))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/image4")
    fun getImage4Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("image4" to response.data.Image4))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/video")
    fun getVideoOnly(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            val cleanId = response.data.Url_Video?.let { extractVideoId(it) } ?: response.data.Url_Video
            ResponseEntity.ok(mapOf("Url_Video" to cleanId))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/video1")
    fun getVideo1Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            val cleanId = response.data.Url_Video1?.let { extractVideoId(it) } ?: response.data.Url_Video1
            ResponseEntity.ok(mapOf("url_Video1" to cleanId))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/video2")
    fun getVideo2Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            val cleanId = response.data.Url_Video2?.let { extractVideoId(it) } ?: response.data.Url_Video2
            ResponseEntity.ok(mapOf("Url_Video2" to cleanId))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/video3")
    fun getVideo3Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            // FIX: Sebelumnya merujuk ke Url_Video2, sekarang diubah ke Url_Video3
            val cleanId = response.data.Url_Video3?.let { extractVideoId(it) } ?: response.data.Url_Video3
            ResponseEntity.ok(mapOf("Url_Video3" to cleanId))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/video4")
    fun getVideo4Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            val cleanId = response.data.Url_Video4?.let { extractVideoId(it) } ?: response.data.Url_Video4
            ResponseEntity.ok(mapOf("Url_Video4" to cleanId))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/Quote")
    fun getQuoteOnly(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("Quote" to response.data.Quote))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/description")
    fun getDescriptionOnly(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("description" to response.data.Description))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/description1")
    fun getDescription1Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, Any?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("description1" to response.data.Description1))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/description2")
    fun getDescription2Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, Any?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("description2" to response.data.Description2))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/description3")
    fun getDescription3Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, Any?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("description3" to response.data.Description3))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/description4")
    fun getDescription4Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, Any?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("description4" to response.data.Description4))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/caption")
    fun getCaptionOnly(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("caption" to response.data.caption))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/caption1")
    fun getCaption1Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("caption1" to response.data.caption1))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/caption2")
    fun getCaption2Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("caption2" to response.data.caption2))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/caption3")
    fun getcaption3Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("caption3" to response.data.caption3))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/information/{id}/caption4")
    fun getcaption4Only(
        @PathVariable("id") id: String
    ): ResponseEntity<Map<String, String?>> {
        val response = service.getById(id)
        return if (response.data != null) {
            ResponseEntity.ok(mapOf("caption4" to response.data.caption4))
        } else {
            ResponseEntity.status(404).build()
        }
    }

    @GetMapping("/categories")
    fun getCategories(): ResponseEntity<List<Map<String, Any>>> {
        val response = service.getCategories()
        return ResponseEntity.ok()
            .header("Cache-Control", "public, max-age=86400")
            .body(response.data ?: emptyList())
    }

    @GetMapping("/languages")
    fun getLanguages(): ResponseEntity<List<Map<String, Any>>> {
        val response = service.getLanguages()
        return ResponseEntity.ok()
            .header("Cache-Control", "public, max-age=86400")
            .body(response.data ?: emptyList())
    }

    @GetMapping("/stats")
    fun getStats(): ResponseEntity<Map<String, Any>> {
        val response = service.getStats()
        return ResponseEntity.ok(response.data ?: emptyMap())
    }

    private fun extractVideoId(youtubeUrl: String): String? {
        val pattern = "(?:youtube\\.com\\/(?:[^\\/\\n\\s]+\\/\\S+\\/|(?:v|e(?:mbed)?)\\/" +
                "|\\S*?[?&]v=)|youtu\\.be\\/)([a-zA-Z0-9_-]{11})"
        val regex = pattern.toRegex()
        val matchResult = regex.find(youtubeUrl)
        return matchResult?.groupValues?.get(1)
    }
}