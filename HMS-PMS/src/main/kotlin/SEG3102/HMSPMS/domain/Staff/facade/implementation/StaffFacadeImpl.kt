package SEG3102.HMSPMS.domain.Staff.facade.implementation

import SEG3102.HMSPMS.application.services.DomainEventEmitter
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.domain.Staff.factories.StaffFactory
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.events.StaffAccountCreated
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

class StaffFacadeImpl (
    private var staffRepository: StaffRepository,
    private var staffFactory: StaffFactory,
    private var domainEventEmitter: DomainEventEmitter

): StaffFacade {

    override fun existsStaff(staffUsername: String) : StaffAccount? {

        return staffRepository.find(staffUsername)

    }

    override fun createAccount(staffInfo: StaffCreateDTO): Boolean {
        var currAccount = existsStaff(staffInfo.username)

        if (currAccount!=null) {
            return false
        }

        currAccount = staffFactory.generateAccount(staffInfo)
        staffRepository.save(currAccount)
        domainEventEmitter.emit(StaffAccountCreated(UUID.randomUUID().toString(),
        Date().toString(),
        currAccount.username))
        return true
    }

}