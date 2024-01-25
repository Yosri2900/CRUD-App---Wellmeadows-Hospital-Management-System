package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.application.usecases.AdmitPatientFromRequestList
import SEG3102.HMSPMS.domain.Log.facade.LogFacade
import SEG3102.HMSPMS.domain.Division.facade.DivisionFacade
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import java.util.*

class AdmitPatientFromRequestListImpl(val divFacade: DivisionFacade, val staffFacade: StaffFacade,
val patFacade: PatientFacade, val logsFacade: LogFacade ): AdmitPatientFromRequestList {

    override fun admitPatientFromRequestList(patID: String, staffUserName: String,
                                             divId: String, doctorId: String, bed: Int?, roomNumber: Int?,
                                             privInsNumber: String?): Boolean {
        val staffUser = staffFacade.existsStaff(staffUserName)
//        val admReq = divFacade.selectPatientRequest(patID, divId)

        
//        if (staffUser.jobTitle == "Charge Nurse" && admReqID !=null) {
//            val patInfo = patFacade.existPatient(patID)
//            val roomNumber = divFacade.getAvailableRoom()
//            val bedNumber = divFacade.getAvailableBed(roomNumber)
//            if (patInfo != null) {
//                logsFacade.logFileAccess(patInfo)
//            }
//            return patInfo?.let { divFacade.admitPatientFromRequestList(it, admReqID, roomNumber, bedNumber) }
//        }

        if (staffUser!=null) {
            return divFacade.admitPatientFromRequestList(patID, divId, staffUserName, doctorId,
                roomNumber, bed, privInsNumber)
        }

        return false
    }    
}