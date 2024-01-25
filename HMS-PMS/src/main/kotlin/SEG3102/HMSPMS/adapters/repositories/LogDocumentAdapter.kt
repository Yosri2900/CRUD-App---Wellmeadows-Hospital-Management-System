package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.LogsDocConverter
import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem
import SEG3102.HMSPMS.domain.Log.repositories.LogsRepo
import SEG3102.HMSPMS.infrastructure.mongodb.repos.LogsMongoDbRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component

@Component
class LogDocumentAdapter(val logsMongoDbRepo: LogsMongoDbRepository): LogsRepo {
    private val converter = Mappers.getMapper(LogsDocConverter::class.java)

    override fun save(logItem: LogItem): LogItem {
        logsMongoDbRepo.save(converter.convertToDoc(logItem))

        return logItem
    }

}