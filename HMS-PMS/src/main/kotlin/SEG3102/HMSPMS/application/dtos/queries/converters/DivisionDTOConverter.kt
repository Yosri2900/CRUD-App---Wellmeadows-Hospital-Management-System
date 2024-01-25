package SEG3102.HMSPMS.application.dtos.queries.converters

import SEG3102.HMSPMS.domain.Division.entities.division.Division
import SEG3102.HMSPMS.domain.Division.entities.room.Room
import SEG3102.HMSPMS.dtos.queries.DivisionCreateDTO
import org.mapstruct.Mapper

@Mapper
interface DivisionDTOConverter {
    fun convertDTO(divisionCreateDto: DivisionCreateDTO, divId: String):
            Division
}