package SEG3102.HMSPMS.domain.Division.factories

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord

interface AdmissionFactory {
    fun createAdmission(divId: String, privInsNum: String?, bed: Int, room: Int,
                        patId: String, admReq: AdmissionRequest?,
                        doctorId: String): AdmissionRecord
}