package SEG3102.HMSPMS.adapters.services.implementation

import SEG3102.HMSPMS.application.services.DomainEventEmitter
import SEG3102.HMSPMS.domain.common.DomainEvent
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class DomainEventEmitterAdapter: DomainEventEmitter {
    @Autowired
    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    override fun emit(event: DomainEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}