package SEG3102.HMSPMS.contracts.testStubs.repositories

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionsRepository
import java.util.HashMap

class AdmissionsRepositoryStub : AdmissionsRepository{
    private val admissionsRepo : MutableMap<String, AdmissionRecord> = HashMap()
    override fun find(patientId: String): AdmissionRecord? {
        return admissionsRepo[patientId]
    }

    override fun save(admInfo: AdmissionRecord): AdmissionRecord {
        admissionsRepo[admInfo.patId] = admInfo
        return admInfo
    }

    override fun remove(admInfo: AdmissionRecord): Boolean {
        admissionsRepo.remove(admInfo.patId)
        return true
    }

}