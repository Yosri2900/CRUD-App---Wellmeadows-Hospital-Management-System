package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.application.usecases.RegisterStaff
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO

class RegisterStaffImpl (
        private var staffFacade: StaffFacade
) : RegisterStaff {

    override fun addStaff(staffInfo: StaffCreateDTO): Boolean {
        return staffFacade.createAccount(staffInfo)
    }
}