package SEG3102.HMSPMS.domain.Staff.facade

import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

interface StaffFacade {
    fun createAccount(staffInfo: StaffCreateDTO): Boolean

    fun existsStaff(staffInfo: String) : StaffAccount?

}