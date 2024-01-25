package SEG3102.HMSPMS.application.usecases.intgr.unit

import SEG3102.HMSPMS.application.usecases.RegisterStaff
import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class RegisterStaffImplTest {

    lateinit var createStaffAccount: RegisterStaff

    lateinit var staffRepository: StaffRepository

    @Test
    fun registeringStaff() {
        val staff1 = StaffCreateDTO(
                "john",
                "doe",
                "Nurse",
                "johndoe@gmail.com",
                "johndoe1"
        )

        val staff2 = StaffCreateDTO(
                "robert",
                "martin",
                "External Doctor",
                "robertmartin@gmail.com",
                "Dr.Martin"
        )

        val es1 = createStaffAccount.addStaff(staff1)
        val es2 = createStaffAccount.addStaff(staff2)

        Assertions.assertThat(es1).isTrue()

        val newEs1 = staffRepository.find(staff1.username)
        Assertions.assertThat(newEs1).isNotNull
        Assertions.assertThat(newEs1?.username).isEqualTo("johndoe1")
        Assertions.assertThat(es2).isTrue()
    }
}