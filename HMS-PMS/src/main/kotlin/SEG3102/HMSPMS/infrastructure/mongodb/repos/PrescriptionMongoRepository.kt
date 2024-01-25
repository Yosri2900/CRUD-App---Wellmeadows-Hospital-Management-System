package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.PrescriptionDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface PrescriptionMongoRepository: MongoRepository<PrescriptionDocument, String> {
}