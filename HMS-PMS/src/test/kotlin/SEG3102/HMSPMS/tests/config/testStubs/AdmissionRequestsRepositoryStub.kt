package SEG3102.HMSPMS.tests.config.testStubs

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionRequestsRepository
import java.util.HashMap

class AdmissionRequestsRepositoryStub : AdmissionRequestsRepository {

private val admissionsRequest : MutableMap<String, AdmissionRequest> = HashMap()
    override fun findPatientRequest(patientId: String): AdmissionRequest? {
        return admissionsRequest[patientId]
    }

    override fun save(request: AdmissionRequest): AdmissionRequest {
        admissionsRequest[request.patId] = request
        return request
    }

    override fun remove(request: AdmissionRequest): Boolean {
        return true
//        TODO("Not yet implemented")
    }

}