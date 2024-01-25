package SEG3102.HMSPMS.application.usecases

import java.util.*

interface DischargePatient {
    fun dischargePatient(staffUsername: String, patId: String, divId: String): Boolean
}