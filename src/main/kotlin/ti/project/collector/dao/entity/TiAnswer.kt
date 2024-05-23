package ti.project.collector.dao.entity

import java.util.*
import javax.persistence.*

/*
{
    "date": "Дата",
    "threatType": "Тип угрозы",
    "countries": "Страны распространения",
    "typeOfDistribution": "Тип распространения",
    "description": "Краткое описание"
}
*/

@Entity
@Table(name = "ti_answer")
data class TiAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    val id: Long? = 0,
    var date: Date? = null,
    var threatType: String?, // TODO("Сделать енум")
    var countries: String?,  // TODO("Сделать енум")
    var typeOfDistribution: String?,
    var description: String?,
    var tiMessageId: Long? = null
)