package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.application.usecases.RegisterPatient
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO

class RegisterPatientImpl (
    private var staffFacade: StaffFacade,
    private var patientFacade: PatientFacade
) : RegisterPatient {


    override fun addPatient (patientInfo: PatientCreateDTO,  staffUsername: String) : Boolean {
        val cs = staffFacade.existsStaff(staffUsername)
//        val ps = patientInfo.HMSPMSID?.let { patientFacade.existPatient(it) }
//        if (cs && ps == null) {
//            patientFacade.addPatient(patientInfo)
//            return true
//        }
//        return false
        if (cs != null) {
            println("Role " + cs.jobTitle)
        }
        if (cs != null && cs.jobTitle=="Charge Nurse") {
            print("reached the if stamtetneww")
            return patientFacade.addPatient(patientInfo)
        }
        return false
    }
}
