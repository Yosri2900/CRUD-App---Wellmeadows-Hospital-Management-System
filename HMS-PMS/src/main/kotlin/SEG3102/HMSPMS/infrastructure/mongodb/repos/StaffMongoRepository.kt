package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface StaffMongoRepository: MongoRepository<StaffDocument, String> {
    fun findByUsername(username: String): StaffDocument?

    fun existsByUsername(username: String): Boolean

}