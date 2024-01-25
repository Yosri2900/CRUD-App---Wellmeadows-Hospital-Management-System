package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffAccountDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface AccountsMongoRepository: MongoRepository<StaffAccountDocument, String> {
    fun findByUsername(username: String): StaffAccountDocument?

    fun existsByUsername(username: String): Boolean
}