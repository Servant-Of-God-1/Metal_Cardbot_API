package Metalcardbot_testmyapi_kotlin_restful_api.repository

import Metalcardbot_testmyapi_kotlin_restful_api.model.Information
import jakarta.annotation.PostConstruct
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Repository
import tools.jackson.databind.ObjectMapper
import tools.jackson.module.kotlin.readValue
import java.util.concurrent.ConcurrentHashMap

@Repository
class InformationRepository {

    private val informationCache = ConcurrentHashMap<String, Information>()
    private val categoryIndex = ConcurrentHashMap<String, MutableList<String>>()
    private val languageIndex = ConcurrentHashMap<String, MutableList<String>>()
    private val objectMapper = ObjectMapper()

    @PostConstruct
    fun loadData() {
        try {
            val resource = ClassPathResource("data/information.json")
            val data: List<Information> = objectMapper.readValue(resource.inputStream)
            data.forEach { info ->
                informationCache[info.id] = info
                categoryIndex.getOrPut(info.category) { mutableListOf() }.add(info.id)
                languageIndex.getOrPut(info.language) { mutableListOf() }.add(info.id)
            }
            println("✅ Loaded ${informationCache.size} items")
        } catch (e: Exception) {
            println("❌ Error: ${e.message}")
        }
    }

    fun findById(id: String): Information? = informationCache[id]

    fun findAll(
        page: Int,
        pageSize: Int,
        category: String? = null,
        language: String? = null,
        name: String? = null
    ): List<Information> {
        var filteredIds = when {
            category != null && language != null -> {
                val catIds = categoryIndex[category.lowercase()] ?: emptyList()
                val langIds = languageIndex[language.lowercase()] ?: emptyList()
                catIds.intersect(langIds.toSet())
            }
            category != null -> categoryIndex[category.lowercase()] ?: emptyList()
            language != null -> languageIndex[language.lowercase()] ?: emptyList()
            else -> informationCache.keys
        }

        if (!name.isNullOrBlank()) {
            val searchTerm = name.replace("_", " ").lowercase()
            filteredIds = filteredIds.filter { id ->
                informationCache[id]?.name?.lowercase()?.contains(searchTerm) == true
            }.toSet()
        }

        val fromIndex = (page - 1) * pageSize
        val toIndex = minOf(fromIndex + pageSize, filteredIds.size)
        if (fromIndex >= filteredIds.size) return emptyList()
        return filteredIds.toList().subList(fromIndex, toIndex).mapNotNull { informationCache[it] }
    }

    fun count(category: String? = null, language: String? = null): Int {
        return when {
            category != null && language != null -> {
                val catIds = categoryIndex[category.lowercase()] ?: emptyList()
                val langIds = languageIndex[language.lowercase()] ?: emptyList()
                catIds.intersect(langIds.toSet()).size
            }
            category != null -> categoryIndex[category.lowercase()]?.size ?: 0
            language != null -> languageIndex[language.lowercase()]?.size ?: 0
            else -> informationCache.size
        }
    }

    fun getCategories(): List<Map<String, Any>> {
        return categoryIndex.map { (cat, ids) ->
            mapOf("category" to cat, "totalItems" to ids.size)
        }.sortedBy { it["category"].toString() }
    }

    fun getLanguages(): List<Map<String, Any>> {
        return languageIndex.map { (lang, ids) ->
            val name = when (lang) {
                "id" -> "Indonesia"
                "en" -> "English"
                else -> lang
            }
            mapOf("code" to lang, "name" to name, "totalItems" to ids.size)
        }.sortedBy { it["code"].toString() }
    }

    fun getStats(): Map<String, Any> {
        return mapOf(
            "totalItems" to informationCache.size,
            "totalCategories" to categoryIndex.size,
            "totalLanguages" to languageIndex.size
        )
    }
}