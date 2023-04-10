package cloud.drakon.ktdiscord.interaction

/**
 * An Interaction is the message that your application receives when a user uses an application command or a message component.
 *
 * For Slash Commands, it includes the values that the user submitted.
 *
 * For User Commands and Message Commands, it includes the resolved user or message on which the action was taken.
 *
 * For Message Components it includes identifying information about the component that was used. It will also include some metadata about how the interaction was triggered: the `guild_id`, `channel_id`, `member` and other fields. You can find all the values in our data models below.
 */
interface InteractionData
