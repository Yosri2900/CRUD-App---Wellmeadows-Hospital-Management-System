package SEG3102.HMSPMS.adapters.factories

import SEG3102.HMSPMS.application.dtos.queries.converters.PatientDTOConverter
import SEG3102.HMSPMS.application.dtos.queries.converters.StaffDTOConverter
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.factory.PatientFactory
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.util.*

@Primary
@Component
class PatientDTOFactory: PatientFactory {
    private val dtoConverter = Mappers.getMapper(PatientDTOConverter::class.java)

    override fun createPatient(patient: PatientCreateDTO): PatientAccount {
        return dtoConverter.convertDto(patient)
    }


}