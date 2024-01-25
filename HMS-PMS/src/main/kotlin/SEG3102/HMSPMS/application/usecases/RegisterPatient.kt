package SEG3102.HMSPMS.application.usecases

import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO

interface RegisterPatient {
    fun addPatient(patientInfo: PatientCreateDTO, staffUsername: String): Boolean

//    fun existPatient(patientAcc: PatientAccount) : Boolean
}