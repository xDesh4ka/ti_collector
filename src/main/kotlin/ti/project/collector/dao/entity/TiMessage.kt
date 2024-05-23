package ti.project.collector.dao.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ti_message")
data class TiMessage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    val id: Long = 0,
    val date: Date,
    val text: String
)