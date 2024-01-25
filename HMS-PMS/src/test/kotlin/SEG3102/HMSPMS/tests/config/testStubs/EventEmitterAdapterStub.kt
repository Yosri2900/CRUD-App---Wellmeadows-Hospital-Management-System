package SEG3102.HMSPMS.tests.config.testStubs

import SEG3102.HMSPMS.application.services.DomainEventEmitter
import SEG3102.HMSPMS.domain.Division.events.NewAdmittedPatient
import SEG3102.HMSPMS.domain.Division.events.NewRequestAdded
import SEG3102.HMSPMS.domain.Division.events.PatientDischarged
import SEG3102.HMSPMS.domain.Patient.events.NewPrescriptionAdded
import SEG3102.HMSPMS.domain.Patient.events.PatientAccountCreated
import SEG3102.HMSPMS.domain.Staff.events.StaffAccountCreated
import SEG3102.HMSPMS.domain.common.DomainEvent
import kotlin.collections.ArrayList

class EventEmitterAdapterStub : DomainEventEmitter {
    private val emitted: MutableList<DomainEvent> = ArrayList()

    override fun emit(event: DomainEvent) {
        emitted.add(event)
    }

    // Next 3 are found in the Division.events
    fun newAdmittedPatient() : NewAdmittedPatient? {
        return emitted.find { it is NewAdmittedPatient} as NewAdmittedPatient
    }

    fun newRequestAdded() : NewRequestAdded? {
        return emitted.find { it is NewRequestAdded} as NewRequestAdded
    }

    fun patientDischarged() : PatientDischarged? {
        return emitted.find { it is PatientDischarged} as PatientDischarged
    }

    // Next 2 are found in the Patient.events
    fun newPrescriptionAdded() : NewPrescriptionAdded? {
        return emitted.find { it is NewPrescriptionAdded} as NewPrescriptionAdded
    }

    fun patientAccountCreated() : PatientAccountCreated? {
        return emitted.find { it is PatientAccountCreated} as PatientAccountCreated
    }

    // Next 1 is found in Staff.events
    fun staffAccountCreated() : StaffAccountCreated? {
        return emitted.find { it is StaffAccountCreated} as StaffAccountCreated
    }

}
