package SEG3102.HMSPMS.application.services

import SEG3102.HMSPMS.domain.common.DomainEvent
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO

interface DomainEventEmitter {
    fun emit(event: DomainEvent)
}