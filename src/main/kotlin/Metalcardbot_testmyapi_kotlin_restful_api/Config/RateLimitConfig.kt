package Metalcardbot_testmyapi_kotlin_restful_api.config

import jakarta.servlet.*
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

@Configuration
class RateLimitConfig {
    @Bean
    fun rateLimitFilter(): Filter {
        val counts = ConcurrentHashMap<String, Pair<Long, AtomicInteger>>()
        return object : Filter {
            override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
                val response = res as HttpServletResponse
                val ip = req.remoteAddr
                val now = System.currentTimeMillis()
                val (ts, counter) = counts.getOrPut(ip) { Pair(now, AtomicInteger(0)) }
                if (now - ts > 60000) counts[ip] = Pair(now, AtomicInteger(0))
                if (counter.incrementAndGet() > 100) {
                    response.status = 429
                    response.contentType = "application/json"
                    response.writer.write("""{"code":429,"status":"TOO_MANY_REQUESTS","data":null}""")
                    return
                }
                chain.doFilter(req, response)
            }
            override fun init(config: FilterConfig?) {}
            override fun destroy() {}
        }
    }
}