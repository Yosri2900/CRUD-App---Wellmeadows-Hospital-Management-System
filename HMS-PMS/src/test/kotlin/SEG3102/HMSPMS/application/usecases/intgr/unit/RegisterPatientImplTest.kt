package SEG3102.HMSPMS.application.usecases.intgr.unit

import SEG3102.HMSPMS.application.dtos.queries.NokCreateDTO
import SEG3102.HMSPMS.application.usecases.RegisterPatient
import SEG3102.HMSPMS.domain.Patient.entities.nextofkin.NextOfKin
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class RegisterPatientImplTest {

    @Autowired
    lateinit var createPatientAccount: RegisterPatient

    @Autowired
    lateinit var patientRepository: PatientRepository

    @Test
    fun registerPatients() {
        val patient1 = PatientCreateDTO(
                "1",
                "marco",
                "polo",
                "marcopolo@gmail.com",
                "613-000-0001",
                "100 main st",
                "Male",
                "NOT MARRIED",
                "robertmartins@gmail.com",
                null,
                mutableMapOf()
        )

        val patient2 = PatientCreateDTO(
                "2",
                "martha",
                "smith",
                "marthats@gmail.com",
                "613-000-0002",
                "101 main st",
                "F",
                "MARRIED",
                "robertmartins@gmail.com",
                NokCreateDTO(
                        "marc",
                        "husband",
                        "101 main st",
                        "613-001-0002"
                ),
                mutableMapOf()
        )

        val patient1Acc = createPatientAccount.addPatient(patient1, "marcop1")
        val patient2Acc = createPatientAccount.addPatient(patient2, "marthasmith1")

        Assertions.assertThat(patient1Acc).isTrue()

        val newEs1 = patientRepository.find("marcop1")
        Assertions.assertThat(newEs1).isNotNull
        Assertions.assertThat(newEs1?.id).isEqualTo("1")
        Assertions.assertThat(patient2Acc).isTrue()
    }
}