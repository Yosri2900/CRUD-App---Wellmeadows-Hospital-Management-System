package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.application.usecases.RequestPatientAdmission
import SEG3102.HMSPMS.domain.Division.facade.DivisionFacade
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import java.util.*

class RequestPatientAdmissionImpl(val divFacade: DivisionFacade, val staffFacade: 
StaffFacade, val patientFacade: PatientFacade): RequestPatientAdmission {
    
    override fun requestPatientAdm(patientID: String, reqInfo: RequestCreateDTO, staffUsername: String): Boolean {
        val userInfo = staffFacade.existsStaff(staffUsername)
        val pat = patientFacade.existPatient(patientID)
        println("inside requestPatientAdm()")
        if (pat != null && userInfo !=null) {
            println("reached past the if statement")
            return divFacade.addRequest(patientID, staffUsername, reqInfo)
        }
        return false
    }
}
