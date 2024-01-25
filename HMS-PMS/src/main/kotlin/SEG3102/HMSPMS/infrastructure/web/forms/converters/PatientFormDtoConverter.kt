package SEG3102.HMSPMS.infrastructure.web.forms.converters

import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.infrastructure.web.forms.PatientForm
import org.mapstruct.Mapper

@Mapper
abstract class PatientFormDtoConverter {
    abstract fun convertFormPatient(formData: PatientForm): PatientCreateDTO
}