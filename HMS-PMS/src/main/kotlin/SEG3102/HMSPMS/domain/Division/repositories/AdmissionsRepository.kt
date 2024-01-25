package SEG3102.HMSPMS.domain.Division.repositories

import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord

interface AdmissionsRepository {
    fun find(patientId: String): AdmissionRecord?
    fun save(admInfo: AdmissionRecord): AdmissionRecord
    fun remove(admInfo: AdmissionRecord): Boolean
}