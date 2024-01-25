package SEG3102.HMSPMS.contracts.testStubs.factories

import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.domain.Patient.factories.PrescriptionFactory
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO

class PrescriptionFactoryStub : PrescriptionFactory {
    override fun createPrescription(prescription: PrescriptionCreateDTO, presId: String): Prescription {
        return Prescription(
                presId,
                prescription.presName,
                prescription.unitsPerDay,
                prescription.numAdmPerDay,
                prescription.adminTimeAndNumUnitsRecord,
                prescription.admMethod,
                prescription.startDate,
                prescription.endDate
        )
    }
}