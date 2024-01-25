package SEG3102.HMSPMS.infrastructure.mongodb.repos

import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.DivisionDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface DivisionMongoRepository: MongoRepository<DivisionDocument, String> {
    fun findByDivId(divId: String): DivisionDocument?
}