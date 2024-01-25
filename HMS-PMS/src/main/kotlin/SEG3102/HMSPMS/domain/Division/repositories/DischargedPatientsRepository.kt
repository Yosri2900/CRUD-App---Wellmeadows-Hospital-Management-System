package SEG3102.HMSPMS.domain.Division.repositories

import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import java.util.*

interface DischargedPatientsRepository {
    fun find(patientID: String): AdmissionRecord?
    fun save(admRecord: AdmissionRecord): AdmissionRecord
    
}