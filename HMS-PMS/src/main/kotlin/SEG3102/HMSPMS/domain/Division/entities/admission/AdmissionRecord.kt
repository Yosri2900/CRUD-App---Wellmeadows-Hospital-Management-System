package SEG3102.HMSPMS.domain.Division.entities.admission

import java.util.*

class AdmissionRecord (
    var patId: String,
    var privInsNum: String?,
    var divId: String?,
    var roomNumber: Int,
    var bedNumber: Int,
    var localDoctorId: String,
    var admissionDate: String,
    var dischargeDate: String?
)