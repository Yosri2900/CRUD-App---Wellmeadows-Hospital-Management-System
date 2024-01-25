package SEG3102.HMSPMS.infrastructure.web.forms.converters

import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import SEG3102.HMSPMS.infrastructure.web.forms.StaffAccountForm
import org.mapstruct.Mapper

@Mapper
abstract class AccountFormDtoConverter {
    abstract fun convertFormAccount(formData: StaffAccountForm): StaffCreateDTO
}