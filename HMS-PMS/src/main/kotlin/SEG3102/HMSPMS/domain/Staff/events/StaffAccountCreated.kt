package SEG3102.HMSPMS.domain.Staff.events

import SEG3102.HMSPMS.domain.common.DomainEvent

class StaffAccountCreated(
    val eventId: String,
    val date: String,
    val accountUsername: String
): DomainEvent {
}