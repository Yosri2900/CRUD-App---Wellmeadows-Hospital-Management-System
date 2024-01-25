package SEG3102.HMSPMS.domain.Log.facade

import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem

interface LogFacade {
    fun logFileAccess(patientInfo: String): LogItem
}