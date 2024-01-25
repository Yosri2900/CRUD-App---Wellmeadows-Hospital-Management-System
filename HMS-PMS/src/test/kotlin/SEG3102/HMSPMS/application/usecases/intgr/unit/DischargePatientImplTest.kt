package SEG3102.HMSPMS.application.usecases.intgr.unit

import SEG3102.HMSPMS.application.dtos.queries.NokCreateDTO
import SEG3102.HMSPMS.application.usecases.DischargePatient
import SEG3102.HMSPMS.application.usecases.PatientAdmission
import SEG3102.HMSPMS.application.usecases.RegisterPatient
import SEG3102.HMSPMS.application.usecases.RegisterStaff
import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.entities.division.Division
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.entities.room.Room
import SEG3102.HMSPMS.domain.Division.repositories.DivisionRepository
import SEG3102.HMSPMS.domain.Patient.entities.nextofkin.NextOfKin
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DischargePatientImplTest {


    lateinit var createStaffAccount: RegisterStaff

    lateinit var staffRepository: StaffRepository

    lateinit var divisionRepo: DivisionRepository

    lateinit var createPatientAccount: RegisterPatient

    lateinit var patientRepository: PatientRepository

    lateinit var dischargePatient: DischargePatient

    lateinit var admitPatient: PatientAdmission

    lateinit var division: DivisionRepository

    @Test
    fun patientsOut() {

        val division1 = Division(
                "0001",
                "foot division",
                "613-foot-fooot",
                "johndoe1",
                mutableMapOf(
                        1 to Room(1,
                                mutableSetOf(1,2,3,4)),
                        2 to Room(2,
                                mutableSetOf(1,2,3,4)),
                        3 to Room(3,
                                mutableSetOf(1,2,3,4)),
                        4 to Room(4,
                                mutableSetOf(1,2,3,4)),
                        5 to Room(5,
                                mutableSetOf(1,2,3,4)),
                        6 to Room(6,
                                mutableSetOf(1,2,3,4)),
                        7 to Room(7,
                                mutableSetOf(1,2,3,4)),
                        8 to Room(8,
                                mutableSetOf(1,2,3,4))
                ),
                mutableMapOf(
//                    "0001" to AdmissionRequest(
//                            "1",
//                            "0001",
//                            "broken foot",
//                            8,
//                            "7-05-2023",
//
//                    )
                ),
                mutableMapOf(
//                    "0001" to AdmissionRecord(
//                            "1",
//                            null,
//                            1,
//                            1,
//                            "Dr.Martin",
//                            "7-05-2023",
//                            "29-11-2023",
//                    )
                ),
                mutableMapOf()
        )

        val staff1dto = StaffCreateDTO(
                "john",
                "doe",
                "Charge Nurse",
                "johndoe@gmail.com",
                "johndoe1"
        )

        val staff2dto = StaffCreateDTO(
                "robert",
                "martin",
                "External Doctor",
                "robertmartin@gmail.com",
                "Dr.Martin"
        )

        val staff1 = StaffAccount(                "johndoe1",
                "john",
                "doe",
                "johndoe1",
                "jogndoe@gmail.com")
        val staff2 = StaffAccount(                "Dr.Martin",
                "robert",
                "martin",
                "External Doctor",
                "robertmartin@gmail.com")

        val patient1dto = PatientCreateDTO(
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

        val patient2dto = PatientCreateDTO(
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
        val patient1 = PatientAccount(                "1",
                "marco",
                "polo",
                "marcopolo@gmail.com",
                "613-000-0001",
                "100 main st",
                "M",
                "NOT MARRIED",
                "robertmartins@gmail.com",
                null,
                mutableMapOf())

        val patient2 = PatientAccount(
                "2",
                "martha",
                "smith",
                "marthats@gmail.com",
                "613-000-0002",
                "101 main st",
                "F",
                "MARRIED",
                "robertmartins@gmail.com",
                NextOfKin(
                        "marc",
                        "husband",
                        "101 main st",
                        "613-001-0002"
                ),
                mutableMapOf()
        )

        val res = dischargePatient.dischargePatient("johndoe1","1", "0001")
        Assertions.assertThat(res).isFalse()

    }

}
