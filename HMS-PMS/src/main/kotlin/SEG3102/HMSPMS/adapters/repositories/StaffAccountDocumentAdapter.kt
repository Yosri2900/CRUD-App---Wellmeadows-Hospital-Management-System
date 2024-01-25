package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.StaffAccountDocumentConverter
import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.StaffMongoRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component

@Component
class StaffAccountDocumentAdapter(private val staffRepo: StaffMongoRepository): StaffRepository {
    private val converter = Mappers.getMapper(StaffAccountDocumentConverter::class.java)

    override fun find(staffUsername: String): StaffAccount? {
        val staffDoc = staffRepo.findByUsername(staffUsername)
        return staffDoc?.let { converter.convertToModel(it) }
    }

    override fun save(staffAccount: StaffAccount): StaffAccount {
        val staffDoc = converter.convertToDoc(staffAccount)
        staffRepo.save(staffDoc)
        return staffAccount
    }
}