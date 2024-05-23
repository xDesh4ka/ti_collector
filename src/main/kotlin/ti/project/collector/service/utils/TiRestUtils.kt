package ti.project.collector.service.utils

import ti.project.collector.dao.entity.TiAnswer
import ti.project.collector.dao.entity.TiMessage
import ti.project.collector.service.TiRestService

fun TiRestService.getProcessedAiAnswer(url: String = "/getReport", tiMessage: TiMessage): TiAnswer {
    return tiRestTemplate.postTiAnswer(url, tiMessage) ?: throw Exception("Ошибка при получении ответа от AiEngine")
}