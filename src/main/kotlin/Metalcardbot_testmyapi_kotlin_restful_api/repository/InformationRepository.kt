package Metalcardbot_testmyapi_kotlin_restful_api.repository

import Metalcardbot_testmyapi_kotlin_restful_api.model.Information
import org.springframework.stereotype.Repository

@Repository
class InformationRepository {

    private val informationList = listOf(
        Information(
            id = "people-001-id",
            name = "Cara Install Spring Boot",
            Image = "https://images.unsplash.com/photo-1518770660439-4636190af475?w=800",
            Description = "Tutorial lengkap cara install Spring Boot untuk pemula dari awal sampai selesai.",
            Url_Video = "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            category = "People",
            language = "id"
        ),
        Information(
            id = "people-002-id",
            name = "Apa itu Kotlin?",
            Image = "https://images.unsplash.com/photo-1485827404703-89b55fcc595e?w=800",
            Description = "Pengenalan bahasa pemrograman Kotlin untuk pengembangan aplikasi Android dan backend.",
            Url_Video = "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            category = "People",
            language = "id"
        ),
        Information(
            id = "people-003-id",
            name = "Machine Learning Dasar",
            Image = "https://images.unsplash.com/photo-1487017155336-0e3c0a44e1e4?w=800",
            Description = "Panduan dasar machine learning untuk pemula menggunakan Python dan TensorFlow.",
            Url_Video = "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            category = "People",
            language = "id"
        ),

        // ==========================================
        // TEKNOLOGI - ENGLISH
        // ==========================================
        Information(
            id = "people-001-en",
            name = "How to Install Spring Boot",
            Image = "https://images.unsplash.com/photo-1518770660439-4636190af475?w=800",
            Description = "Complete beginner tutorial to install Spring Boot from scratch.",
            Url_Video = "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            category = "People",
            language = "en"
        ),
        Information(
            id = "people-002-en",
            name = "What is Kotlin?",
            Image = "https://images.unsplash.com/photo-1485827404703-89b55fcc595e?w=800",
            Description = "Introduction to Kotlin programming language for Android and backend development.",
            Url_Video = "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            category = "People",
            language = "en"
        ),
        Information(
            id = "people-003-en",
            name = "Basic Machine Learning",
            Image = "https://images.unsplash.com/photo-1487017155336-0e3c0a44e1e4?w=800",
            Description = "Beginner's guide to machine learning using Python and TensorFlow.",
            Url_Video = "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            category = "People",
            language = "en"
        ),

        // ==========================================
        // WISATA - INDONESIA
        // ==========================================
        Information(
            id = "robot-001-id",
            name = "Pantai Kuta Bali",
            Image = "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0?w=800",
            Description = "Keindahan Pantai Kuta di Bali yang terkenal dengan sunset dan ombak untuk surfing.",
            Url_Video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            category = "Robot",
            language = "id"
        ),
        Information(
            id = "robot-002-id",
            name = "Candi Borobudur",
            Image = "https://images.unsplash.com/photo-1537996194471-e657f975b604?w=800",
            Description = "Wisata sejarah ke Candi Borobudur di Yogyakarta, candi Buddha terbesar di dunia.",
            Url_Video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            category = "Robot",
            language = "id"
        ),

        // ==========================================
        // WISATA - ENGLISH
        // ==========================================
        Information(
            id = "robot-001-en",
            name = "Kuta Beach Bali",
            Image = "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0?w=800",
            Description = "The beautiful Kuta Beach in Bali, famous for sunset views and surfing waves.",
            Url_Video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            category = "Robot",
            language = "en"
        ),
        Information(
            id = "robot-002-en",
            name = "Borobudur Temple",
            Image = "https://images.unsplash.com/photo-1537996194471-e657f975b604?w=800",
            Description = "Historical tour to Borobudur Temple in Yogyakarta, the world's largest Buddhist temple.",
            Url_Video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            category = "Robot",
            language = "en"
        )
    )

    fun findById(id: String): Information? {
        return informationList.find { it.id == id }
    }

    fun findAll(page: Int, pageSize: Int, category: String? = null, language: String? = null): List<Information> {
        var filteredList = informationList

        if (!category.isNullOrBlank()) {
            filteredList = filteredList.filter { it.category.equals(category, ignoreCase = true) }
        }

        if (!language.isNullOrBlank()) {
            filteredList = filteredList.filter { it.language.equals(language, ignoreCase = true) }
        }

        val fromIndex = (page - 1) * pageSize
        val toIndex = minOf(fromIndex + pageSize, filteredList.size)

        if (fromIndex >= filteredList.size) return emptyList()
        return filteredList.subList(fromIndex, toIndex)
    }

    fun count(category: String? = null, language: String? = null): Int {
        var filteredList = informationList

        if (!category.isNullOrBlank()) {
            filteredList = filteredList.filter { it.category.equals(category, ignoreCase = true) }
        }
        if (!language.isNullOrBlank()) {
            filteredList = filteredList.filter { it.language.equals(language, ignoreCase = true) }
        }

        return filteredList.size
    }

    fun getCategories(): List<Map<String, Any>> {
        val categories = informationList.map { it.category }.distinct().sorted()
        return categories.map { cat ->
            mapOf(
                "category" to cat,
                "totalItems" to informationList.count { it.category == cat }
            )
        }
    }

    fun getLanguages(): List<Map<String, Any>> {
        val languages = informationList.map { it.language }.distinct().sorted()
        return languages.map { lang ->
            val langName = when (lang) {
                "id" -> "Indonesia"
                "en" -> "English"
                else -> lang
            }
            mapOf(
                "code" to lang,
                "name" to langName,
                "totalItems" to informationList.count { it.language == lang }
            )
        }
    }
}