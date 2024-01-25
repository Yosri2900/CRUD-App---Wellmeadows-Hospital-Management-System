package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.PrescriptionDocument
import org.mapstruct.Mapper

@Mapper
interface PrescriptionsDocumentConverter {
    fun convertToDoc(prescription: Prescription): PrescriptionDocument

    fun convertToModel(prescriptionDocument: PrescriptionDocument): Prescription

}