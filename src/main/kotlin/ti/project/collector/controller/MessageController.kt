package ti.project.collector.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ti.project.collector.dao.entity.TiMessage
import ti.project.collector.service.TiMessageService


@RestController
@RequestMapping("/ti/message")
@Api(tags = ["Сообщения TI"])
@Tag(name = "Сообщения TI")
class TiMessageController {
    @Autowired
    lateinit var tiMessageService: TiMessageService

    @GetMapping("/get/{id}")
    @ApiOperation("Получить сообщение по id")
    fun getMessageById(@PathVariable id: Long): TiMessage {
        return tiMessageService.getMessageById(id)
    }

    @PostMapping("/set")
    @ApiOperation("Добавить или обновить сообщение по id")
    fun addMessage(@RequestBody tiMessageDao: TiMessage): TiMessage {
        return tiMessageService.addMessage(tiMessageDao)
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удалить сообщение по id")
    fun deleteMessage(@PathVariable id: Long) {
        tiMessageService.deleteMessage(id)
    }

}


