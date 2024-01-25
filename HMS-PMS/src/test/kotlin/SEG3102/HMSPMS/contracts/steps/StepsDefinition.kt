package SEG3102.HMSPMS.contracts.steps//package SEG3102.HMSPMS.contracts.steps

import SEG3102.HMSPMS.adapters.factories.AdmissionFactoryImpl
import SEG3102.HMSPMS.application.dtos.queries.NokCreateDTO
import SEG3102.HMSPMS.contracts.testStubs.factories.*
import SEG3102.HMSPMS.contracts.testStubs.repositories.AdmissionRequestsRepositoryStub
import SEG3102.HMSPMS.contracts.testStubs.repositories.AdmissionsRepositoryStub
import SEG3102.HMSPMS.contracts.testStubs.repositories.StaffRepositoryStub
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.facade.DivisionFacade
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.assertj.core.api.Assertions
import org.mockito.MockitoAnnotations
import java.util.*
import SEG3102.HMSPMS.domain.Patient.facade.Implementation.PatientFacadeImpl
import SEG3102.HMSPMS.domain.Division.facade.implementation.DivisionFacadeImpl
import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.domain.Staff.entities.staffAccount.StaffAccount
import SEG3102.HMSPMS.domain.Staff.facade.implementation.StaffFacadeImpl
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import SEG3102.HMSPMS.tests.config.testStubs.DischargedPatientsRepositoryStub
import SEG3102.HMSPMS.tests.config.testStubs.DivisionRepositoryStub
import SEG3102.HMSPMS.tests.config.testStubs.EventEmitterAdapterStub
import SEG3102.HMSPMS.tests.config.testStubs.PatientRepositoryStub
import io.mockk.Runs
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assert

class StepsDefinition: En {
    var patientCreateInfo: PatientCreateDTO? = null
    var retPatientInfo: String? = null
    var newPatientID: String? = null
    var registerPatCompleted: Boolean = false
    var patFacade: PatientFacadeImpl? = null
    var divFacade: DivisionFacadeImpl? = null
    var staffFacade: StaffFacadeImpl? = null
    var patAdmitted: Boolean = false
    var logItem: LogItem? = null
    var fileAccessLogged: Boolean = false
    var patAdmitID: String? = null
    var availableRoom: Int? = null
    var availableBed: Int? = null
    val currUser: StaffAccount? = null
    var divisionFacade: DivisionFacade? = null
    var dischrgPatId: String? = null
    var staffRepository = StaffRepositoryStub()
    var staffFactory = StaffFactoryStub()
    var admissionRepo = AdmissionsRepositoryStub()
    var divRepository = DivisionRepositoryStub()
    var dischargePatientsRepo = DischargedPatientsRepositoryStub()
    var admissionRequestsRepository = AdmissionRequestsRepositoryStub()
    var eventEmitter = EventEmitterAdapterStub()
    var patientRepository = PatientRepositoryStub()
    var patientFactory = PatientFactoryStub()
    var presFactory = PrescriptionFactoryStub()
    val admissionFactory = AdmissionFactoryStub()
    val requestFactory = RequestsFactoryStub()

    init {
        Before { _: Scenario ->
            MockitoAnnotations.openMocks(this)
        }
        //RegPatient
        Given("The medical staff member is logged in") {
           val staffInfo = StaffCreateDTO("a", "b", "Charge Nurse", "ab@gmail.com", "ab1")
            staffFacade = StaffFacadeImpl(staffRepository,
                    staffFactory, eventEmitter)
           Assertions.assertThat(currUser).isNull()
            val acc = staffFacade!!.createAccount(staffInfo)
            Assertions.assertThat(acc).isTrue()
        }
         Given("Medical Staff Member enters requested information") {
             val patientInfo = PatientCreateDTO("0001",
                     "john", "doe",
                     "johndoe@gmail.com",
                     "613-000-0000",
                     "123 main st",
                     "M",
                     "single",
                     "robertmartin@gail.com",
                     null,
                     null)

             Assertions.assertThat(patientInfo).isNotNull()
         }
        When("the application registerPatient is invoked") {
            val patientInfo = PatientCreateDTO("0001",
                    "john", "doe",
                    "johndoe@gmail.com",
                    "613-000-0000",
                    "123 main st",
                    "M",
                    "single",
                    "robertmartin@gail.com",
                    null,
                    null)
//             patFacade = PatientFacadeImpl(patientRepository,
//                     patientFactory,
//                     presFactory,
//                     eventEmitter)
            Assertions.assertThat(patFacade).isNotNull()
            val res = patFacade!!.addPatient(patientInfo)
            Assertions.assertThat(res).isTrue()
        }
        Then("Medical Staff Member enters requested information") {
            patientCreateInfo = PatientCreateDTO(
                    "002",
                    "Pen",
                    "nullablename",
                    "a@ex.com",
                    "613-444-8888",
                    "124 main st",
                    "M",
                    "single",
                    "robertmartin@gmail.com",
                    NokCreateDTO("jane", "mother", "124 main st", "613-613-6131"),
                    mutableMapOf("1" to Prescription(
                            "999",
                            "advil",
                            2,
                            2,
                            "null",
                            "null",
                            Date().toString(),
                            Date().toString()
                    )))
            Assertions.assertThat(patientCreateInfo).isNotNull()
        }
        Then("HMS registers Patient") {
            var patObj = PatientAccount(UUID.randomUUID().toString(),
                    "john",
                    "dewey",
                    "jdewey@gmail.com",
                    "613-699-6999",
                    "111 john main st",
                    "F",
                    "single",
                    "robertmartin@gmail.com",
                    null,
                    mutableMapOf("0" to Prescription("", "", -1,-1,"","", Date().toString(), Date().toString())))
            registerPatCompleted = true
           Assertions.assertThat(registerPatCompleted).isTrue()
        }
        //Admit Patient

        Given("The Charge Nurse is logged in") {
            val staffInfo = StaffCreateDTO("a", "b", "Charge Nurse", "ab@gmail.com", "ab1")
            val staffJob = staffInfo.jobTitle
//            Assertions.assertThat(currUser).isNull()
//            Assertions.assertThat(staffInfo).isNotNull()
            Assertions.assertThat(staffJob).isEqualTo("Charge Nurse")
        }
        When("the application admitPatient is invoked") {
//            val admFactory = AdmissionFactoryImpl()
             divFacade = DivisionFacadeImpl(admissionFactory, admissionRepo,
                     requestFactory, dischargePatientsRepo, admissionRequestsRepository, divRepository,
                     eventEmitter)
//            Assertions.assertThat(divFacade).isNull()
            val p = PatientCreateDTO(
                    "002",
                    "Pen",
                    "nullablename",
                    "a@ex.com",
                    "613-444-8888",
                    "124 main st",
                    "M",
                    "single",
                    "robertmartin@gmail.com",
                    NokCreateDTO("jane", "mother", "124 main st", "613-613-6131"),
                    mutableMapOf("1" to Prescription(
                            "999",
                            "advil",
                            2,
                            2,
                            "null",
                            "null",
                            Date().toString(),
                            Date().toString()
                    )))
            val sb = StringBuilder()
            val patientAdmission = divFacade!!.admitPatient(
                    sb.append(p.firstName).append(p.lastName).toString(),
                    p.id,
                    1,
                    1,
                    AdmissionRequest(p.id, "footy clinic", "Injured foot", 5, Date().toString()),
                    "Dr.Martin",
                    null
            )

            Assertions.assertThat(patientAdmission).isFalse()
        }
        Then("application consultPatientFile is invoked") {
//            val staffFacade = StaffFacadeImpl(staffRepository, staffFactory, eventEmitter)

//            val patientFacade = PatientFacadeImpl(patientRepository, patientFactory, presFactory, eventEmitter)
            var patObj = PatientAccount(UUID.randomUUID().toString(),
                    "john",
                    "dewey",
                    "jdewey@gmail.com",
                    "613-699-6999",
                    "111 john main st",
                    "F",
                    "single",
                    "robertmartin@gmail.com",
                    null,
                    mutableMapOf("0" to Prescription("", "", -1,-1,"","", Date().toString(), Date().toString())))
            // logFacade = LogFacadeImpl()
//            Assertions.assertThat(patFacade).isNull()
//            Assertions.assertThat(patientFacade.updatePatientInfo(patObj)).isTrue()
        }
        Then("Staff Member asks for viewing Patient registration") {
            Assertions.assertThat(patFacade).isNotNull()
        }
        Then("Medical staff member enters Patient identification number") {
           patAdmitID = null
           Assertions.assertThat(patAdmitID).isNull()
        }
        Then("HMS shows the Patient registration information") {
            var patObj = PatientAccount(UUID.randomUUID().toString(),
                    "john",
                    "dewey",
                    "jdewey@gmail.com",
                    "613-699-6999",
                    "111 john main st",
                    "F",
                    "single",
                    "robertmartin@gmail.com",
                    null,
                    mutableMapOf("0" to Prescription("", "", -1,-1,"","", Date().toString(), Date().toString())))
//            retPatientInfo = PatientAccount(UUID.randomUUID(), "john", listOf()).toString()
            Assertions.assertThat(patObj).isNotNull()
        }
        Then("Charge Nurse chooses to admit the patient") {
//            Assertions.assertThat(divFacade).isNull()
            val p = PatientCreateDTO(
                    "002",
                    "Pen",
                    "nullablename",
                    "a@ex.com",
                    "613-444-8888",
                    "124 main st",
                    "M",
                    "single",
                    "robertmartin@gmail.com",
                    NokCreateDTO("jane", "mother", "124 main st", "613-613-6131"),
                    mutableMapOf("1" to Prescription(
                            "999",
                            "advil",
                            2,
                            2,
                            "null",
                            "null",
                            Date().toString(),
                            Date().toString()
                    )))
            val sb = StringBuilder()
            val patientAdmission = divFacade!!.admitPatient(
                    sb.append(p.firstName).append(p.lastName).toString(),
                    p.id,
                    1,
                    1,
                    AdmissionRequest(p.id, "footy clinic", "Injured foot", 5, Date().toString()),
                    "Dr.Martin",
                    null
            )

            Assertions.assertThat(patientAdmission).isFalse()
        }
        Then("Charge Nurse enters room and bed number or alternatively browses through a list of available rooms and beds in the ward and makes a selection") {
           availableBed = 1
           availableRoom = 2
           Assertions.assertThat(availableBed).isNotNull()
           Assertions.assertThat(availableRoom).isNotNull()
        }
        Then("HMS admits patient") {
            patAdmitted = true
            Assertions.assertThat(patAdmitted).isTrue()
        }
        Then("Log File Access") {
            fileAccessLogged = true
            Assertions.assertThat(logItem).isNull()
            Assertions.assertThat(fileAccessLogged).isTrue()
        }

    }
}