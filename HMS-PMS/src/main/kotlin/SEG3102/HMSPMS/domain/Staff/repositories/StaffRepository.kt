package SEG3102.HMSPMS.domain.Staff.repositories

import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

interface StaffRepository {
    fun find(staffUsername: String): StaffAccount?
    fun save(staffAccount: StaffAccount): StaffAccount
}