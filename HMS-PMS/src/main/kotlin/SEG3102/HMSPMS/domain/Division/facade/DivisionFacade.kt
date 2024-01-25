package SEG3102.HMSPMS.domain.Division.facade

import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest

interface DivisionFacade {
    //
    fun admitPatient(staffUsername: String, patientId: String, roomNumber: Int?, bed: Int?, admissionRequest:
    AdmissionRequest, doctorId: String, privInsNum: String?): Boolean
    // 5
    fun addRequest(patID: String, staffUsername: String, requestInfo: RequestCreateDTO): Boolean
    // 6
    fun admitPatientFromRequestList(patId: String, divId: String, staffUsername: String, doctorId: String,
     roomNumber: Int?, bedNumber: Int?, privInsNum: String?): Boolean
    // 7
    fun dischargePatient(patId: String, divId: String, currUser: String): Boolean

}