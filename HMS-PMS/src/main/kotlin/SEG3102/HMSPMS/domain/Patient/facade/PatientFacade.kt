package SEG3102.HMSPMS.domain.Patient.facade

import java.util.*
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO


interface PatientFacade {
    fun addPrescription(patientAccount: PatientAccount, pres: PrescriptionCreateDTO): Boolean
    fun addPatient(patientInfo: PatientCreateDTO): Boolean
    fun updatePatientInfo(patientAccount: PatientAccount): Boolean
    fun existPatient(patientId: String) : PatientAccount?
}