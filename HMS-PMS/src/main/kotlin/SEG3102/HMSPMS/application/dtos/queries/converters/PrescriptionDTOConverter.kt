package SEG3102.HMSPMS.application.dtos.queries.converters

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO
import org.mapstruct.Mapper

@Mapper
interface PrescriptionDTOConverter {
    fun convertDTO(prescriptionCreateDTO: PrescriptionCreateDTO, presId: String): Prescription
}