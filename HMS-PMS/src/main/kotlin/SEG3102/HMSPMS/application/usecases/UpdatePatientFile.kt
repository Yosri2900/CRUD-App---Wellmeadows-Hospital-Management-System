package SEG3102.HMSPMS.application.usecases

import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

interface UpdatePatientFile {
    fun updatePatient(staffUsername: String, patientInfo: PatientAccount) : Boolean
}