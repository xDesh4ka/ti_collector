package ti.project.collector.utils

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.client.RestTemplate
import ti.project.collector.dao.entity.TiAnswer
import ti.project.collector.dao.entity.TiMessage

class TiRestTemplate(private val baseUrl: String,
                     private val restTemplate: RestTemplate) {

    companion object {
        fun createForUrl(baseUrl: String) : TiRestTemplate {
            val restTemplate = RestTemplateBuilder().rootUri(baseUrl).build()
            val converter = StringHttpMessageConverter(Charsets.UTF_8).apply { setWriteAcceptCharset(true) }
            restTemplate.messageConverters.add(0, converter)
            return TiRestTemplate(baseUrl, restTemplate)
        }
    }

    fun postTiAnswer(url: String, tiMessageDao: TiMessage): TiAnswer? {
        val json = tiMessageDao.toJson()
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }
        val entity = HttpEntity(json, headers)
        try {
            val response = restTemplate.exchange(url, HttpMethod.POST, entity, String::class.java).body
            val tiMessageFromJson = tiMessageFromJson(response)
//            val response = restTemplate.exchange(url, HttpMethod.POST, entity, String::class.java).body
            return tiMessageFromJson
        } catch (e: Exception) {
            throw e
        }
    }
}