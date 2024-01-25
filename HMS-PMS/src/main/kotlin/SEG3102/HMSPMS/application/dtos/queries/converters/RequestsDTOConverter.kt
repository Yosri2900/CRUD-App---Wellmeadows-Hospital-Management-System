package SEG3102.HMSPMS.application.dtos.queries.converters

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import org.mapstruct.Mapper

@Mapper
interface RequestsDTOConverter {
    fun convertDTO(requestDTO:RequestCreateDTO): AdmissionRequest
}