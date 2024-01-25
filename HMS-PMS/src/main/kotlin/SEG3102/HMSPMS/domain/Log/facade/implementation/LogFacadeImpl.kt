package SEG3102.HMSPMS.domain.Log.facade.implementation

import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem
import SEG3102.HMSPMS.domain.Log.facade.LogFacade
import SEG3102.HMSPMS.domain.Log.factories.LogFactory
import SEG3102.HMSPMS.domain.Log.repositories.LogsRepo
import java.util.*

class LogFacadeImpl(
    private val logFactory: LogFactory,
    private val logsRepo: LogsRepo): LogFacade {

    override fun logFileAccess(patientInfo: String): LogItem {
        val logItem = logFactory.createLog(UUID.randomUUID().toString(), patientInfo);
        logsRepo.save(logItem)
        return logItem
    }
}