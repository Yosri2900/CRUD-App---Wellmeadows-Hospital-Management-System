package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.application.usecases.PrescribeMedication
import SEG3102.HMSPMS.domain.Log.facade.LogFacade
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO

class PrescribeMedicationImpl(val staffFacade: StaffFacade,
val patFacade: PatientFacade, val logsFacade: LogFacade): PrescribeMedication {
    
    override fun prescribeMedicationToPatient(staffUsername: String, patientId: String,
                                              presInfo: PrescriptionCreateDTO): Boolean {
        val currUser = staffFacade.existsStaff(staffUsername)
        val pat = patFacade.existPatient(patientId)
        if (currUser != null) {
            println("user em "+currUser.email)
        }
        if (pat != null) {
            println("pat email "+pat.doctorEmail)
        }
        if (pat!=null && currUser!=null && currUser.email==pat.doctorEmail) {
            println("pat "+pat.id)
//            logsFacade.logFileAccess(pat)
//            return divFacade.addPrescription(presInfo, pat, currUser)

              return patFacade.addPrescription(pat, presInfo)
        }
        return false
    }
}