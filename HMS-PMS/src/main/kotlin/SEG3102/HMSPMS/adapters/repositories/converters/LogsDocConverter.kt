package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem
import SEG3102.HMSPMS.infrastructure.mongodb.documents.logs.LogDocument
import org.mapstruct.Mapper

@Mapper
interface LogsDocConverter {
    fun convertToDoc(logItem: LogItem): LogDocument

    fun convertToModel(logDocument: LogDocument): LogItem
}