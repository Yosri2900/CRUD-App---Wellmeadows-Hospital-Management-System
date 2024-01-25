package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRecordDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface AdmissionsMongoRepository: MongoRepository<AdmissionRecordDocument, String> {
}