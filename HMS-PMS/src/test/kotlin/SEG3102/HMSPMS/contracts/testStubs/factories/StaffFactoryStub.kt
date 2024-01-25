package SEG3102.HMSPMS.contracts.testStubs.factories

import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.factories.StaffFactory
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO

class StaffFactoryStub : StaffFactory {
    override fun generateAccount(staffInfo: StaffCreateDTO): StaffAccount {
        return StaffAccount(
            staffInfo.username,
                staffInfo.firstName,
                staffInfo.lastName,
                staffInfo.jobTitle,
                staffInfo.email
        )
    }

}