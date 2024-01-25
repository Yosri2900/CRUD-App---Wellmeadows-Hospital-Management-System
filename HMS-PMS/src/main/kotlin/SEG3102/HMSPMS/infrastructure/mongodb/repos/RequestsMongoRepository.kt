package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRequestDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface RequestsMongoRepository: MongoRepository<AdmissionRequestDocument, String> {
}