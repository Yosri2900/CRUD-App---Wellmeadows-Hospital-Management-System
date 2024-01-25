package SEG3102.HMSPMS.domain.Division.events

import SEG3102.HMSPMS.domain.common.DomainEvent
import java.util.*

class NewAdmittedPatient(
    val id: String,
    val admissionID: String,
    val creationDate: String

): DomainEvent 