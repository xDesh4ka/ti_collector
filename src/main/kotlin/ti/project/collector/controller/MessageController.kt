package ti.project.collector.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import ti.project.collector.dao.entity.TiMessageDao
import ti.project.collector.dao.repo.TiMessageRepo


@RestController
@RequestMapping("/ti/message")
@Api(tags = ["Сообщения TI"])
@Tag(name = "Сообщения TI")
class TiMessageController {
    @Autowired
    lateinit var tiMessageRepository: TiMessageRepo

    @GetMapping("/get/{id}")
    @ApiOperation("Получить сообщение по id")
    fun getMessageById(@PathVariable id: Long): TiMessageDao {
        return tiMessageRepository.findByIdOrNull(id) ?: throw Exception("Сообщение с id = $id не найдено")
    }

    @PostMapping("/set")
    @ApiOperation("Добавить или обновить сообщение по id")
    fun addMessage(@RequestBody tiMessageDao: TiMessageDao): TiMessageDao {
        return tiMessageRepository.save(tiMessageDao)
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удалить сообщение по id")
    fun deleteMessage(@PathVariable id: Long) {
        tiMessageRepository.deleteById(id)
    }

}


