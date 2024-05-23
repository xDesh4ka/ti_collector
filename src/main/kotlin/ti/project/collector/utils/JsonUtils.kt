package ti.project.collector.utils

import com.google.gson.*
import ti.project.collector.dao.entity.TiAnswer
import ti.project.collector.dao.entity.TiMessage
import java.lang.reflect.Type
import java.text.SimpleDateFormat


val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd")

fun TiMessage.toJson(): String {
    val gson = GsonBuilder()
        .registerTypeAdapter(TiMessage::class.java, TiMessageSerializer())
        .setPrettyPrinting()
        .serializeNulls()
        .create()

    return gson.toJson(this, TiMessage::class.java)
}

fun tiMessageFromJson(json: String): TiAnswer {
    val gson = GsonBuilder()
        .registerTypeAdapter(TiAnswer::class.java, TiAnswerJsonDeserializer())
        .create()
    return gson.fromJson(json, TiAnswer::class.java)
}

private open class TiMessageSerializer(): JsonSerializer<TiMessage> {
    override fun serialize(src: TiMessage, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        val jsonObject = JsonObject().apply {
            addProperty("date", src.date.toString())
            addProperty("text", src.text)
        }
        return jsonObject
    }

}

/*
{
    "date": "Дата",
    "threatType": "Тип угрозы",
    "countries": "Страны распространения",
    "typeOfDistribution": "Тип распространения",
    "description": "Краткое описание"
}
*/
private open class TiAnswerJsonDeserializer(): JsonDeserializer<TiAnswer> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TiAnswer {
        val result = TiAnswer(null, null, null, null, null, null)
        val jsonObject = json.asJsonObject
        jsonObject.keySet().forEach { key ->
            val value = jsonObject[key]
            when (key) {
                "threatType" -> if (value != null) result.threatType = value.asString
                "countries" -> if (value != null) result.countries = value.asString
                "typeOfDistribution" -> if (value != null) result.typeOfDistribution = value.asString
                "description" -> if (value != null) result.description = value.asString
            }
        }
        return result
    }
}