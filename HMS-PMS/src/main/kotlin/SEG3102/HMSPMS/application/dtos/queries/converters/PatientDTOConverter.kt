package SEG3102.HMSPMS.application.dtos.queries.converters

import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import org.mapstruct.Mapper

@Mapper
interface PatientDTOConverter {
    fun convertDto(patientCreateDTO: PatientCreateDTO): PatientAccount
}