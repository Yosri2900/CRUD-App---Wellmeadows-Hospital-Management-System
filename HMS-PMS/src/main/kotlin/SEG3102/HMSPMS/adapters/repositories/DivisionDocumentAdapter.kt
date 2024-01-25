package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.DivisionDocumentConverter
import SEG3102.HMSPMS.domain.Division.entities.division.Division
import SEG3102.HMSPMS.domain.Division.repositories.DivisionRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.DivisionMongoRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component

@Component
class DivisionDocumentAdapter(val divisionMongoRepo: DivisionMongoRepository): DivisionRepository {
    private val converter = Mappers.getMapper(DivisionDocumentConverter::class.java)

    override fun find(divisionId: String): Division? {
        val divRecord = divisionMongoRepo.findByDivId(divisionId)
        return divRecord?.let { converter.convertToModel(it) }
    }

    override fun save(division: Division): Division? {
        val divDoc = converter.convertToDoc(division)
        divisionMongoRepo.save(divDoc)
        return division
    }
}