package ti.project.collector.dao.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ti.project.collector.dao.entity.TiMessageDao

@Repository
interface TiMessageRepo : JpaRepository<TiMessageDao, Long>
