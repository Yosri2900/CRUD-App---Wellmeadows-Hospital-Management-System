package SEG3102.HMSPMS.domain.Patient.factory

import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

interface PatientFactory {
    fun createPatient(patient: PatientCreateDTO) : PatientAccount
}