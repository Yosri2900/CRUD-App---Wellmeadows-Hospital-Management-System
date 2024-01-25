package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.application.usecases.PatientAdmission
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.facade.DivisionFacade
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade

class PatientAdmissionImpl (
        private val patientFacade: PatientFacade,
        private val divisionFacade: DivisionFacade,
)
    : PatientAdmission {

    override fun admitPatient(staffUsername: String, admissionRequest: AdmissionRequest, patientId: String,
                              doctorId: String,  room: Int?,
                              bed: Int?, privInsNum: String?): Boolean {
        val ep = patientFacade.existPatient(patientId)
        // LOGS TO DO

        if (ep!=null) {
            println("executed the admitPatient - PatientAdmission Impl")
            return divisionFacade.admitPatient(staffUsername, patientId, room, bed,
                admissionRequest, doctorId, privInsNum)
        }

        return false

    }
}