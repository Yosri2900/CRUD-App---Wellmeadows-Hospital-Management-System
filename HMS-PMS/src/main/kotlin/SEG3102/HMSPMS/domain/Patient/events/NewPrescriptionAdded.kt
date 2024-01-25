package SEG3102.HMSPMS.domain.Patient.events

import java.util.*
import SEG3102.HMSPMS.domain.common.DomainEvent

class NewPrescriptionAdded (
    val id: String,
    val presDate: Date,
    val doctorEmail: String
): DomainEvent