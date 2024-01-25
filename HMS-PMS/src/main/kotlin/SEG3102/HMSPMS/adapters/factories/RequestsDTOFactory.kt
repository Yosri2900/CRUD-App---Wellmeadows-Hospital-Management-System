package SEG3102.HMSPMS.adapters.factories

import SEG3102.HMSPMS.application.dtos.queries.converters.RequestsDTOConverter
import SEG3102.HMSPMS.application.dtos.queries.converters.StaffDTOConverter
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.factories.RequestsFactory
import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Primary
@Component
class RequestsDTOFactory: RequestsFactory {
    private val dtoConverter = Mappers.getMapper(RequestsDTOConverter::class.java)

    override fun createRequest(reqInfo: RequestCreateDTO): AdmissionRequest {
        return dtoConverter.convertDTO(reqInfo)
    }

}