package SEG3102.HMSPMS.domain.Division.repositories

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest

interface AdmissionRequestsRepository {
    fun findPatientRequest(patientId: String): AdmissionRequest?
    fun save(request: AdmissionRequest): AdmissionRequest
    fun remove(request: AdmissionRequest): Boolean
}