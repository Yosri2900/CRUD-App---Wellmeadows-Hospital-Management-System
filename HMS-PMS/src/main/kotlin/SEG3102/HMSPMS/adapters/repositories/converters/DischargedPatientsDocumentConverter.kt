package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRecordDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.DischargeRecordDocument
import org.mapstruct.Mapper

@Mapper
interface DischargedPatientsDocumentConverter {
    fun convertToDoc(admissionRecord: AdmissionRecord): DischargeRecordDocument

    fun convertToModel(dischargeRecordDocument: DischargeRecordDocument): AdmissionRecord
}