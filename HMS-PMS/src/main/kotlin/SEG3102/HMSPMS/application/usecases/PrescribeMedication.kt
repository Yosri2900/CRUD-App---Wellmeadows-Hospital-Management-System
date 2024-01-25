package SEG3102.HMSPMS.application.usecases

import java.util.*
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO

interface PrescribeMedication {
    fun prescribeMedicationToPatient(staffUsername: String, patientId: String,
    presInfo: PrescriptionCreateDTO): Boolean
}

