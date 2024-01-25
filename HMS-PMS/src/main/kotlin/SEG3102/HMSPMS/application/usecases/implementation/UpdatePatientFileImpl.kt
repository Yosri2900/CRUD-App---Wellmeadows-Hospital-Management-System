package SEG3102.HMSPMS.application.usecases.implementation

import SEG3102.HMSPMS.application.usecases.UpdatePatientFile
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade

class UpdatePatientFileImpl
        (
        private var patientFacade: PatientFacade,
        private var staffFacade: StaffFacade,
        )
    : UpdatePatientFile {

    override fun updatePatient(staffUsername: String, patientInfo: PatientAccount): Boolean {
        val es = staffFacade.existsStaff(staffUsername)
        val pat = patientFacade.existPatient(patientInfo.id)

        if (es!=null && pat!=null) {
            patientFacade.updatePatientInfo(patientInfo)
            return true
        }

        return false
    }
}