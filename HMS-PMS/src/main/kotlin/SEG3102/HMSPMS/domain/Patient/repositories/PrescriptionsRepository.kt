package SEG3102.HMSPMS.domain.Patient.repositories

import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription

interface PrescriptionsRepository {
    fun find(presId: String): Prescription?
    //    fun save(staffInfo: StaffInfo): StaffInfo
    fun save(prescription: Prescription): Prescription
}