package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.application.usecases.DischargePatient

import SEG3102.HMSPMS.domain.Log.facade.LogFacade
import SEG3102.HMSPMS.domain.Division.facade.DivisionFacade
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade

class DischargePatientImpl(
    private val divFacade: DivisionFacade, val staffFacade: StaffFacade,
    private val patFacade: PatientFacade, val logsFacade: LogFacade ) : DischargePatient {
   
    override fun dischargePatient(staffUsername: String, patId: String, divId: String): Boolean {
        val currUser = staffFacade.existsStaff(staffUsername)
        val pat = patFacade.existPatient(patId)

        if (pat!=null && currUser !=null) {
            println("deletereached")
            return divFacade.dischargePatient(patId, divId, staffUsername)
        }
        return false
    }
}