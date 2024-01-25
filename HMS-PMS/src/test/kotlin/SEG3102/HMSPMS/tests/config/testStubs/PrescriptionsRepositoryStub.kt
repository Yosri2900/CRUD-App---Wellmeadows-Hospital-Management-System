package SEG3102.HMSPMS.tests.config.testStubs

import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.domain.Patient.repositories.PrescriptionsRepository

class PrescriptionsRepositoryStub : PrescriptionsRepository {
    private val prescriptionRepo : MutableMap<String, Prescription> = HashMap()
    override fun find(presId: String): Prescription? {
        return prescriptionRepo[presId]
    }

    override fun save(prescription: Prescription): Prescription {
        TODO("Not yet implemented")
    }

    fun savePatient(prescription: Prescription): Prescription {
        prescriptionRepo[prescription.presName] = prescription
        return prescription
    }

}