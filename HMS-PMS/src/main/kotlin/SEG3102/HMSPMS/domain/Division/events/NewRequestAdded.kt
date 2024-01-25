package SEG3102.HMSPMS.domain.Division.events

import SEG3102.HMSPMS.domain.common.DomainEvent
import java.util.*

class NewRequestAdded(
    val id: String,
    val requestID: String,
    val creationDate: String

): DomainEvent 