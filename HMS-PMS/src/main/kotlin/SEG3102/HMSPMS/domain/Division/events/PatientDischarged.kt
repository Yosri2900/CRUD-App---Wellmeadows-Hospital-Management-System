package SEG3102.HMSPMS.domain.Division.events

import SEG3102.HMSPMS.domain.common.DomainEvent
import java.util.*

class PatientDischarged(
    val admissionID: String,
    val patId: String,
    val dischargeDate: Date

): DomainEvent 