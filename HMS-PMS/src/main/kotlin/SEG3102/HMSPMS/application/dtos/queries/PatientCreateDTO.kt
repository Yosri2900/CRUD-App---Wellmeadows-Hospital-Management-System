package SEG3102.HMSPMS.dtos.queries

import SEG3102.HMSPMS.application.dtos.queries.NokCreateDTO
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import org.apache.commons.math3.optim.linear.Relationship
import java.util.*

data class PatientCreateDTO(
        val id: String,
        val firstName: String,
        val lastName: String,
        val patientEmail: String,
        val phoneNumber: String,
        val address: String,
        val gender: String,
        val maritalStatus: String,
        val doctorEmail: String?,
        val nextOfKin: NokCreateDTO?,
        var prescriptions: MutableMap<String, Prescription>?
)

