package SEG3102.HMSPMS.tests.config.testStubs

import SEG3102.HMSPMS.domain.Division.entities.division.Division
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import java.util.HashMap

class PatientRepositoryStub : PatientRepository {
    private val patientRepo : MutableMap<String, PatientAccount> = HashMap()
    override fun find(patientId: String): PatientAccount? {
        return patientRepo[patientId]
    }

    override fun savePatient(patient: PatientAccount): PatientAccount {
        patientRepo[patient.id] = patient
        return patient
    }
}