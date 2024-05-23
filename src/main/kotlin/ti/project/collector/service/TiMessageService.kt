package ti.project.collector.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ti.project.collector.dao.entity.TiMessage
import ti.project.collector.dao.repo.TiAnswerRepo
import ti.project.collector.dao.repo.TiMessageRepo
import ti.project.collector.utils.getProcessedAiAnswer


@Service
class TiMessageService {
    @Autowired
    lateinit var tiMessageRepository: TiMessageRepo
    @Autowired
    lateinit var tiAnswerRepo: TiAnswerRepo
    @Autowired
    lateinit var tiRestService: TiRestService

    fun getMessageById(id: Long) = tiMessageRepository.findByIdOrNull(id) ?: throw Exception("Сообщение с id = $id не найдено")

    fun addMessage(message: TiMessage, generateAnswer: Boolean = true) : TiMessage {
        val tiMessage = tiMessageRepository.save(message)
        if (generateAnswer) {
            val answer = tiRestService.getProcessedAiAnswer(tiMessage = tiMessage).also {
                it.tiMessageId = tiMessage.id
            }
            tiAnswerRepo.save(answer)
        }
        return tiMessage
    }

    fun deleteMessage(id: Long) = tiMessageRepository.deleteById(id)
}