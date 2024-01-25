package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.logs.LogDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface LogsMongoDbRepository: MongoRepository<LogDocument, String> {
}