package SEG3102.HMSPMS.application.usecases

import java.util.*

interface AdmitPatientFromRequestList {
    fun admitPatientFromRequestList(patID: String, staffUserName: String,
                                    divId: String, doctorId: String, bed: Int?, roomNumber: Int?,
                                    privInsNum: String?): Boolean
}