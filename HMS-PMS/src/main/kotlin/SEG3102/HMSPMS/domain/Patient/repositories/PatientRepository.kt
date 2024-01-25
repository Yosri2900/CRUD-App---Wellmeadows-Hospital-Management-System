package SEG3102.HMSPMS.domain.Patient.repositories

import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import java.util.*

interface PatientRepository {
    fun find(patientId: String): PatientAccount?
    //    fun save(staffInfo: StaffInfo): StaffInfo
    fun savePatient(patient: PatientAccount): PatientAccount
}