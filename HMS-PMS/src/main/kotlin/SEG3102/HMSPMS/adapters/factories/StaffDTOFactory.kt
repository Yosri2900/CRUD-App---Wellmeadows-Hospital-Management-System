package SEG3102.HMSPMS.adapters.factories

import SEG3102.HMSPMS.application.dtos.queries.converters.PatientDTOConverter
import SEG3102.HMSPMS.application.dtos.queries.converters.StaffDTOConverter
import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.factories.StaffFactory
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.util.*

@Primary
@Component
class StaffDTOFactory: StaffFactory {
    private val dtoConverter = Mappers.getMapper(StaffDTOConverter::class.java)

    override fun generateAccount(staffCreateDTO: StaffCreateDTO): StaffAccount {
        return dtoConverter.convertDTO(staffCreateDTO)
    }

}