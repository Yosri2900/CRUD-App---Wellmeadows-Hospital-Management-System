package SEG3102.HMSPMS.tests.config.testStubs

import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository

class StaffRepositoryStub : StaffRepository{
    private val staffRepo : MutableMap<String, StaffAccount> = HashMap()
    override fun find(staffUsername: String): StaffAccount? {
        return staffRepo[staffUsername]
    }

    override fun save(staffAccount: StaffAccount): StaffAccount {
        staffRepo[staffAccount.username] = staffAccount
        return staffAccount
    }
}