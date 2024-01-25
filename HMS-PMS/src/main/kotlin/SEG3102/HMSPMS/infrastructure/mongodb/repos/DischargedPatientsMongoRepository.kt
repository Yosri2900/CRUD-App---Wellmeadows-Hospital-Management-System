package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRecordDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.DischargeRecordDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface DischargedPatientsMongoRepository: MongoRepository<DischargeRecordDocument, String> {
}