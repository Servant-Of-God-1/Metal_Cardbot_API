package Metalcardbot_testmyapi_kotlin_restful_api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowedOriginPatterns = listOf("*")
        config.allowedMethods = listOf("GET", "OPTIONS")
        config.allowedHeaders = listOf("*")
        config.maxAge = 3600L
        source.registerCorsConfiguration("/api/**", config)
        return CorsFilter(source)
    }
}