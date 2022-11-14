package interaction

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object InteractionJsonSerializer: JsonContentPolymorphicSerializer<Interaction<*>>(
    Interaction::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out Interaction<*>> {
        return when (val type = element.jsonObject["type"]?.jsonPrimitive?.intOrNull) {
            2, 4 -> Interaction.serializer(ApplicationCommandData.serializer())
            3    -> Interaction.serializer(MessageComponentData.serializer())
            5    -> Interaction.serializer(ModalSubmitData.serializer())
            else -> error("Unknown interaction type $type")
        }
    }
}
