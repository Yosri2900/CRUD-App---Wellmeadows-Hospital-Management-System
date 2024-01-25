package SEG3102.HMSPMS.domain.Staff.factories

import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.UUID

interface StaffFactory {

    fun generateAccount(staffCreateDTO: StaffCreateDTO) : StaffAccount
}