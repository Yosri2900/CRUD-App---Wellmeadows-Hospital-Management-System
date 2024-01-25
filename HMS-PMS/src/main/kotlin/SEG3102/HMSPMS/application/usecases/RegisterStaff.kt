package SEG3102.HMSPMS.application.usecases

import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO

interface RegisterStaff {
    fun addStaff(staffInfo: StaffCreateDTO) : Boolean
}