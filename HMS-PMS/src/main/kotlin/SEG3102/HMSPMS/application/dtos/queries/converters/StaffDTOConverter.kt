package SEG3102.HMSPMS.application.dtos.queries.converters

import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import org.mapstruct.Mapper

@Mapper
interface StaffDTOConverter {
    fun convertDTO(staffCreateDTO: StaffCreateDTO): StaffAccount
}