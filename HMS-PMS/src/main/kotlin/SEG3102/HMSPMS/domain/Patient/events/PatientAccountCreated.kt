package SEG3102.HMSPMS.domain.Patient.events

import SEG3102.HMSPMS.domain.common.DomainEvent

class PatientAccountCreated(
    val id: String,
    val date: String,
    val patId: String
): DomainEvent {
}