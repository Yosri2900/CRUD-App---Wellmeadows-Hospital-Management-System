package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.PatientAccountDocument
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface PatientsMongoRepository: MongoRepository<PatientAccountDocument, String> {
    override fun findById(id: String): Optional<PatientAccountDocument>

}