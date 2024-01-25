package SEG3102.HMSPMS.application.usecases

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

interface PatientAdmission {
    fun admitPatient(staffUsername: String, admissionRequest: AdmissionRequest, patientId: String, doctorId:String,
                     room: Int?, bed: Int?, privInsNum: String?): Boolean
}
