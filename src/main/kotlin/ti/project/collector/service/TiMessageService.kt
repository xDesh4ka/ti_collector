package ti.project.collector.service

import org.springframework.stereotype.Service
import ti.project.collector.dao.repo.TiMessageRepo


@Service
class TiMessageService(
    private val tiMessageRepo: TiMessageRepo
)