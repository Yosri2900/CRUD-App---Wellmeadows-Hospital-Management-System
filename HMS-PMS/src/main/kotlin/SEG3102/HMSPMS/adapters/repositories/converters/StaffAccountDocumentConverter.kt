package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffDocument
import org.mapstruct.Mapper

@Mapper
interface StaffAccountDocumentConverter {
    fun convertToDoc(staffAccount: StaffAccount): StaffDocument

    fun convertToModel(staffAccountDocItem: StaffDocument): StaffAccount
}