package SEG3102.HMSPMS.infrastructure.web.controllers

import SEG3102.HMSPMS.infrastructure.web.ApplicationService
import SEG3102.HMSPMS.infrastructure.web.forms.*
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.security.Principal
import java.util.*

@Controller
class WebController(private val applicationService: ApplicationService) {

    //Get

    //main
    @RequestMapping("/")
    fun homePage(model: Model, session: HttpSession): String{
//        val acc = getCurrentUser(session, principal)
        return "home"
    }


    // Login
    @GetMapping("/login")
    fun showlogin(model: Model, session: HttpSession): String {
        return "staffLogin"
    }

//    @GetMapping("/login/{userId}")
//    fun getStaffAccount(@PathVariable userId: String): StaffAccountDocument? {
//        return applicationService.getAccount(userId)
//    }

//    @GetMapping(value = ["/requestadmission"])
//    fun showRequestAdmission(model: Model, session: HttpSession): String {
//        model.addAttribute("requestData", RequestForm())
//        return "requestAdmission"
//    }

    @GetMapping(value = ["/registerpatient"])
    fun showRegisterPatient(model: Model, session: HttpSession): String {
        model.addAttribute("patientAccountData", PatientForm())
        //TODO: add event listener upon patient creation
        return "registerPatient"
    }

    @GetMapping(value = ["/requestadmission/{id}"])
    fun showRequestFormForPatient(@ModelAttribute("id") id: String, model: Model, session: HttpSession): String {
        println("showRequestFormForPatient()")
        println("Chosen id $id")
        var form = RequestForm()
        form.patId = id
        model.addAttribute("requestform", form)
        model.addAttribute("patientId", id)
        return "requests"
    }


    @GetMapping(value = ["/admittedlist"])
    fun showAdmittedPatients(model: Model, session: HttpSession): String {
        val admissionsData = applicationService.getAdmissions()
        model.addAttribute("admissionData", admissionsData)
        return "admittedlist"
    }


    @GetMapping(value = ["/requestlist"])
    fun showRequests(model: Model, session: HttpSession): String{
        val requestList = applicationService.getRequests()
        model.addAttribute("requestList", requestList)
        return "requestlist"
    }

    @GetMapping(value = ["/patients"]) //update and prescribe TODO
    fun showPatients(model: Model, session: HttpSession): String {
        val patientsList = applicationService.getPatients()
        model.addAttribute("listPatients", patientsList)
        return "patients"
    }

    @GetMapping(value=["/staffs"])
    fun showStaffs(model: Model, session: HttpSession) : String {
        val listStaffs = applicationService.getStaffs()
//        println(listStaffs.joinToString(" "))
        model.addAttribute("listStaffs", listStaffs)
        return "staffs"
    }

    @GetMapping(value = ["/registeruser"])
    fun showRegisterStaff(model: Model, session: HttpSession, principal: Principal): String{
        model.addAttribute("staffaccountdata", StaffAccountForm())
        return "registerUser"
    }

//    Create
    @PostMapping(value = ["/registerstaff"])
    fun createStaffAccount(@ModelAttribute("staffaccountdata") accountData: StaffAccountForm,
                           model: Model, session: HttpSession): String {
        println("save staff to db... @PostMapping")
        println("id: " + accountData.username)
        println("firstName: " + accountData.firstName)
        println("lastName: " + accountData.lastName)
        println("patientEmail: " + accountData.jobTitle)
        println("phoneNumber: " + accountData.email)
        println("address: " + accountData.password)
        applicationService.createAccount(accountData)
        return "redirect:/"
    }

    @PostMapping(value = ["/registerpatient"])
    fun createPatientAccount(@ModelAttribute("patientAccountData") patient: PatientForm,
                             model: Model, session: HttpSession, principal: Principal): String {
        //save patient to db
        println("save patient to db... @PostMapping")
        println("id: " + patient.patId)
        println("firstName: " + patient.firstName)
        println("lastName: " + patient.lastName)
        println("patientEmail: " + patient.patientEmail)
        println("phoneNumber: " + patient.phoneNumber)
        println("address: " + patient.address)
        println("gender: " + patient.gender)
        println("maritalStatus: " + patient.maritalStatus)
        println("nokName: " + patient.nokName)
        println("nokRelationship: " + patient.nokRelationship)
        println("nokAddress: " + patient.nokAddress)
        println("nokPhoneNumber: " + patient.nokPhoneNumber)
        println("doctorEmail: " + patient.doctorEmail)
//        patient.firstName?.let { applicationService.createPatient(patient, it) }
        applicationService.createPatient(patient, principal.name)
        return "redirect:/"
    }

    @GetMapping(value = ["/admitpatient/{id}"])
    //TODO HERE
    fun showAdmitPatientForm(@ModelAttribute("admissionForm") admissionData: AdmissionForm,
                             model: Model, session: HttpSession, principal: Principal, @PathVariable id: String): String {
        println("showAdmitPatientForm(): about to admit patient w id "+ id)
//        applicationService.createAdmission(principal.name, admissionData)
        // gotta show the form
        val admReq = applicationService.getPatientRequest(id)


        if (admReq != null) {
            admissionData.patId= id
            admissionData.divId=admReq.divId
            admissionData.rationale=admReq.rationale
            admissionData.priority=admReq.priority
            admissionData.requestDate=admReq.requestDate
        }
        model.addAttribute("admForm", admissionData)
        model.addAttribute("pid", id)
//        mod

        return "admitpatientform"
    }

    @PostMapping(value = ["/admitpatients/{id}"])
    fun admitPatient(@ModelAttribute("admForm") admissionData: AdmissionForm,
                     model: Model, session: HttpSession, principal: Principal) : String {
        println("only inside admitPatient()")
        println("admition data: "+admissionData.divId)
//        println(admissionData.divId)
//        println(admissionData.patId)
//        println(admissionData.bedNumber)
//        println(admissionData.roomNumber)
//        println(admissionData.doctorId)
//        println(admissionData.rationale)
//        println(admissionData.requestDate)
//        var patientID = admissionData.patId
        applicationService.createAdmission(principal.name, admissionData)

        return "redirect:/"
    }

    @PostMapping(value = ["/requestsadmission"])
    fun addToRequestList(@ModelAttribute("requestform") requestData: RequestForm,
                      model: Model, session: HttpSession, principal: Principal): String
    {
        //TODO: ADD EVENT HANDLER HERE
        println("addToRequestList(). data entered:")
        println(requestData.patId)
        println(requestData.divId)
        println(requestData.rationale)
        println(requestData.priority)
        println(requestData.requestDate)
        println(principal.name)
        applicationService.createRequest(requestData, principal.name)
        return "redirect:/"
    }

    @DeleteMapping(value = ["/dischargepatient/{patId}/{divId}"])
    fun dischargePatient(@PathVariable("patId") patId: String, @PathVariable("divId") divId: String,
                         model: Model, session: HttpSession, principal: Principal): String {
        applicationService.removePatientFromAdmissions(principal.name, patId, divId)
        return "redirect:/"
    }

    @GetMapping("/updatepatient/{id}")
    fun updatePatientPage(@PathVariable("id") id: String, model: Model, session: HttpSession, principal: Principal): String {
        println("clicked the update patient button")

//        val patient: Optional<PatientAccountDocument> = applicationService.getPatientById(id)
//        patient.ifPresent { p->
//            println(p.id)
//            println(p.firstName)
//            println(p.lastName)
//            println(p.patientEmail)
//            println(p.phoneNumber)
//            println(p.address)
//            println(p.gender)
//            println(p.maritalStatus)
//            println(p.nextOfKin?.name)
//            println(p.nextOfKin?.relationshipToPatient)
//            println(p.nextOfKin?.phoneNumber)
//            println(p.nextOfKin?.address)
//            println(p.prescriptions)
//            var staffDocumentObj = getCurrentUser(session, principal)
//            if (staffDocumentObj is StaffDocument) {
//                println("job title "+staffDocumentObj.jobTitle)
//                model.addAttribute("patientAccountData", p)
//                if (staffDocumentObj.jobTitle == "Charge Nurse") {
//                    println("Reached the if statement")
//                    model.addAttribute("changeprescriptions", "no")
//                } else {
//                    model.addAttribute("changeprescriptions", "yes")
//                }
//            }else {
//                println("Object is not a StaffDocument")
//            }
//
//
//        }
        var patForm = PatientForm()
        var patObj = applicationService.getPatientById(id)
        if (patObj != null) {
            patForm.patId = patObj.id
            patForm.firstName = patObj.firstName
            patForm.lastName = patObj.lastName
            patForm.address = patObj.address
            patForm.gender = patObj.gender
            patForm.patientEmail = patObj.patientEmail
            patForm.phoneNumber = patObj.phoneNumber
            patForm.maritalStatus = patObj.maritalStatus
            patForm.doctorEmail = patObj.doctorEmail
            val nokDoc = patObj.nextOfKin
            if (nokDoc != null) {
                patForm.nokName = nokDoc.name
                patForm.nokAddress = nokDoc.address
                patForm.nokRelationship = nokDoc.relationshipToPatient
                patForm.nokPhoneNumber = nokDoc.phoneNumber
            }

        }
        if (patObj != null) {
            model.addAttribute("patPrescriptions",
                patObj.prescriptions.values.toList())
        }
        model.addAttribute("patientAccountData", patForm)

        return "updatepatientform"
    }

    @PutMapping(value=["/updatepatients"])
    fun updatePatientAccountMapper(@ModelAttribute("patientAccountData") updatedPatientForm: PatientForm,
                                   model: Model, session: HttpSession, principal: Principal) : String {

        println("REady to call the api backend")
        println(updatedPatientForm.patId)
        println(updatedPatientForm.firstName)
        println(updatedPatientForm.lastName)
        println(updatedPatientForm.patientEmail)
        println(updatedPatientForm.phoneNumber)
        println(updatedPatientForm.address)
        println(updatedPatientForm.gender)
        println(updatedPatientForm.maritalStatus)
        println(updatedPatientForm.nokName)
        println(updatedPatientForm.nokRelationship)
        println(updatedPatientForm.nokAddress)
        println(updatedPatientForm.nokPhoneNumber)
        println(updatedPatientForm.doctorEmail)
        val currUser = principal.name
        applicationService.updatePatientInfo(currUser, updatedPatientForm)
        return "redirect:/"
    }

    @GetMapping(value = ["/addprescription/{id}"])
    fun showAddPrescription(@PathVariable("id") patId: String, model: Model): String{
        println("provided "+patId)
        model.addAttribute("patientId", patId)
        model.addAttribute("prescriptionData", PrescriptionForm())
        return "addPrescription"
    }

    @PostMapping(value = ["/addPrescription/{patientId}"])
    fun addPrescription(@PathVariable("patientId") patId: String,
                        @ModelAttribute("prescriptionData") prescriptionForm: PrescriptionForm, model: Model,
                        principal: Principal): String{

        applicationService.addPrescriptionForPatient(prescriptionForm, patId, principal.name)

        return "redirect:/"
    }

    //Delete


    private fun getCurrentUser(session: HttpSession, principal: Principal): Any? {
        var account = session.getAttribute("currentUser")
        if (account == null) {
            val userid = principal.name
            account = applicationService.getAccount(userid)
            session.setAttribute("currentUser", account)
        }
        return account
    }
}