package ti.project.collector.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig {
    @Bean
    fun configCORS(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("*") //.allowCredentials(true)
                //.allowedHeaders("Authorization", "Cache-Control", "Content-Type", "Origin", "X-Requested-With", "Access-Control-Allow-Origin")
            }
        }
    }
}
