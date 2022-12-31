package cloud.drakon.ktdiscord.components

import kotlin.js.JsExport

/**
 * Components are a new field on the message object, so you can use them whether you're sending messages or responding to a slash command or other interaction.
 *
 * The top-level `components` field is an array of Action Row components.
 */
@JsExport interface Component
