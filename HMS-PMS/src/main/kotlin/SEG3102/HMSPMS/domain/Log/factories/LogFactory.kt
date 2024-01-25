package SEG3102.HMSPMS.domain.Log.factories

import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem
import java.util.*

interface LogFactory {
    fun createLog(id:String, patientInfo: String): LogItem
}