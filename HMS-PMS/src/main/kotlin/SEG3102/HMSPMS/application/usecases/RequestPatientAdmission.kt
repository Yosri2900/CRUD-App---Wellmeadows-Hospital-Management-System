package SEG3102.HMSPMS.application.usecases

import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

interface RequestPatientAdmission {
    fun requestPatientAdm(patientID: String, reqInfo: RequestCreateDTO, staffUsername: String): Boolean
}