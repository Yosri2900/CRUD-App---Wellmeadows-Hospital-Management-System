package SEG3102.HMSPMS.infrastructure.web

import SEG3102.HMSPMS.application.dtos.queries.NokCreateDTO
import SEG3102.HMSPMS.application.usecases.*
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Patient.entities.nextofkin.NextOfKin
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO
import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRecordDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRequestDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.PatientAccountDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffAccountDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffDocument
import SEG3102.HMSPMS.infrastructure.mongodb.repos.*
import SEG3102.HMSPMS.infrastructure.web.forms.*
import SEG3102.HMSPMS.infrastructure.web.forms.converters.AccountFormDtoConverter
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class ApplicationService(private val admitPatientFromRequestList: AdmitPatientFromRequestList,
                         private val dischargePatient: DischargePatient,
                         private val patientAdmission: PatientAdmission,
                         private val prescribeMedication: PrescribeMedication,
                         private val registerStaff: RegisterStaff,
                         private val registerPatient: RegisterPatient,
                         private val requestPatientAdmission: RequestPatientAdmission,
                         private val updatePatientFile: UpdatePatientFile,
                         private val staffRepo: StaffMongoRepository,
                         private val admissionsRepo: AdmissionsMongoRepository,
                         private val accountsRepo: AccountsMongoRepository,
                         private val admReqRepo: RequestsMongoRepository,
                         private val patientRepo: PatientsMongoRepository,
                         private val requestsRepo: RequestsMongoRepository,
                         private val dischargedRepo: DischargedPatientsMongoRepository,
                         private val prescriptionRepo: PrescriptionMongoRepository,
                         private val encoder: PasswordEncoder
) {
    //Staff service
    private val accountConverter = Mappers.getMapper(AccountFormDtoConverter::class.java)

    fun getAccount(id: String): StaffDocument? {

        return staffRepo.findByUsername(id)
    }

    fun getRequests(): List<AdmissionRequestDocument>{
        return admReqRepo.findAll()
    }
    fun getAdmissions(): List<AdmissionRecordDocument> {
        return admissionsRepo.findAll()
    }

    fun getPatients(): List<PatientAccountDocument> {
        return patientRepo.findAll()
    }

    fun getStaffs() : MutableList<StaffDocument> {
        return staffRepo.findAll()
    }

    fun getPatientById(id: String) : PatientAccountDocument? {
        return patientRepo.findByIdOrNull(id)
    }

    fun createAccount(accountData: StaffAccountForm): Boolean {
        if (staffRepo.existsById(accountData.username!!)) {
            return false
        }
        val user = StaffAccountDocument(accountData.username!!, accountData.firstName!!, accountData.lastName!!,
            accountData.email!!, encoder.encode(accountData.password), accountData.jobTitle!!, true)
        accountsRepo.save(user)
        return registerStaff.addStaff(accountConverter.convertFormAccount(accountData));
    }

    fun createPatient(patientData: PatientForm, currUsername: String): Boolean{
        println("HERE - createPatient()" )
        println("currUserName: " + currUsername)

        if (patientRepo.existsById(patientData.patId!!)) {
            return false
        }

        return registerPatient.addPatient(
            PatientCreateDTO(patientData.patId!!, patientData.firstName!!,
        patientData.lastName!!, patientData.patientEmail!!, patientData.phoneNumber!!, patientData.address!!,
        patientData.gender!!, patientData.maritalStatus!!, patientData.doctorEmail, NokCreateDTO(patientData.nokName!!,
                patientData.nokRelationship!!, patientData.address!!, patientData.phoneNumber!!),
                mutableMapOf()
            ), currUsername)
    }
//
//
    // Patient Service
//    fun addPatient(): Boolean {
//        registerPatient.addPatient(PatientCreateDTO())
//        return true
//    }
    fun addPrescriptionForPatient(prescriptData: PrescriptionForm, patientId: String, currUsername: String): Boolean {
//        return prescribeMedication.prescribeMedicationToPatient("doc1", "123",
//            PrescriptionCreateDTO("tylenol", 3, 3, "dd",
//                "mouth", Date(), Date()))
    println("service reached")
        return prescribeMedication.prescribeMedicationToPatient(currUsername, patientId,
            PrescriptionCreateDTO(prescriptData.presName!!, prescriptData.unitsPerDay!!, prescriptData.numAdmPerDay!!,
            prescriptData.adminTimeAndNumUnitsRecord!!, prescriptData.admMethod!!, prescriptData.startDate!!,
                prescriptData.endDate!!
            )
        )
    }
//
    fun updatePatientInfo(currUsername: String, patientInfo: PatientForm): Boolean {
        println("chosen patient: "+ patientInfo.patId+patientInfo.firstName)
        if (!patientRepo.existsById(patientInfo.patId!!)) return false
        println("passed if statement")

        val patAcc = PatientAccount(patientInfo.patId!!, patientInfo.firstName!!, patientInfo.lastName!!,
            patientInfo.patientEmail!!, patientInfo.phoneNumber!!, patientInfo.address!!, patientInfo.gender!!,
            patientInfo.maritalStatus!!, patientInfo.doctorEmail!!, NextOfKin(patientInfo.nokName!!,
                patientInfo.nokRelationship!!, patientInfo.address!!, patientInfo.phoneNumber!!), mutableMapOf()
        )

        updatePatientFile.updatePatient(currUsername, patAcc)
        return true
    }

    fun getPatientInfo() {

    }


    //Div

    fun createAdmission(currUsername: String, admissionData: AdmissionForm): Boolean {

        println("createAdmission() - app service")


        return  patientAdmission.admitPatient(currUsername, AdmissionRequest(admissionData.patId!!,
        admissionData.divId!!, admissionData.rationale!!, admissionData.priority!!,
            admissionData.requestDate!!), admissionData.patId!!,
            admissionData.doctorId!!,
            admissionData.roomNumber, admissionData.bedNumber, admissionData.privInsNum)


    }

    fun createRequest(requestData: RequestForm, currUsername: String): Boolean {
        println("createRequest() called"+requestData.patId)

        return requestPatientAdmission.requestPatientAdm(requestData.patId!!,
            RequestCreateDTO(requestData.rationale!!, requestData.priority!!, requestData.divId!!, requestData.patId!!,
                Date().toString()), currUsername)
    }


    fun removePatientFromAdmissions(currUsername: String, patId: String, divId: String): Boolean {
        println(currUsername+" "+patId+" "+divId)
        dischargePatient.dischargePatient(currUsername, patId, divId)
        return true
    }

    fun getPatientRequest(patId: String): AdmissionRequestDocument?{
        return admReqRepo.findByIdOrNull(patId)
    }
}