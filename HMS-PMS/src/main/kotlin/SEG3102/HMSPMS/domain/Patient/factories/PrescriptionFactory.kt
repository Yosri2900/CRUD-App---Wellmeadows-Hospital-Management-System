package SEG3102.HMSPMS.domain.Patient.factories

import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO

interface PrescriptionFactory {
    fun createPrescription(prescription: PrescriptionCreateDTO, presId: String): Prescription
}