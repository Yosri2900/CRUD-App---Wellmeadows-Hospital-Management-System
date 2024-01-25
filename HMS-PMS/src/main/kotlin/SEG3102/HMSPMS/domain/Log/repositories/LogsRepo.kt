package SEG3102.HMSPMS.domain.Log.repositories

import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem

interface LogsRepo {
    fun save(logItem: LogItem): LogItem
}