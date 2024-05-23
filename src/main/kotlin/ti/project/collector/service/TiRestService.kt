package ti.project.collector.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import ti.project.collector.utils.TiRestTemplate

@Service
@PropertySource("classpath:application.properties")
class TiRestService {
    @Value("\${collector.rest.aiEngineUrl}")
    private val baseUrl = ""

    lateinit var tiRestTemplate: TiRestTemplate

    @PostConstruct
    fun init() {
        tiRestTemplate = TiRestTemplate.createForUrl(baseUrl)
    }
}