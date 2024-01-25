package SEG3102.HMSPMS.tests.config.testStubs

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.repositories.DischargedPatientsRepository
import java.util.HashMap

class DischargedPatientsRepositoryStub : DischargedPatientsRepository {
    private val dischargedPatients : MutableMap<String, AdmissionRecord> = HashMap()
    override fun find(patientID: String): AdmissionRecord? {
        TODO("Function not used...")
    }

    override fun save(admRecord: AdmissionRecord): AdmissionRecord {
        dischargedPatients[admRecord.patId] = admRecord
        return admRecord
    }

}