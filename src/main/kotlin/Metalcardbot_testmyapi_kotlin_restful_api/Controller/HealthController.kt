package Metalcardbot_testmyapi_kotlin_restful_api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class HealthController {

    @GetMapping("/")
    fun health(): ResponseEntity<Map<String, Any>> {
        return ResponseEntity.ok(mapOf(
            "status" to "UP",
            "service" to "Public Information API",
            "version" to "1.0.0",
            "timestamp" to Instant.now().toString()
        ))
    }
}