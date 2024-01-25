package SEG3102.HMSPMS.domain.Patient.entities.patient

import SEG3102.HMSPMS.application.dtos.queries.NokCreateDTO
import SEG3102.HMSPMS.domain.Patient.entities.nextofkin.NextOfKin
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import java.util.*

class PatientAccount(
        val id: String,
        var firstName: String,
        var lastName: String,
        var patientEmail: String,
        var phoneNumber: String,
        var address: String,
        var gender: String,
        var maritalStatus: String,
        var doctorEmail: String,
        var nextOfKin: NextOfKin?,
        var prescriptions: MutableMap<String, Prescription>
){}