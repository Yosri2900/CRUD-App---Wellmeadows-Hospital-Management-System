package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRecordDocument
import org.mapstruct.Mapper

@Mapper
interface AdmissionsDocumentConverter {
    fun convertToDoc(admissionRecord: AdmissionRecord): AdmissionRecordDocument

    fun convertToModel(admissionRecordDocument: AdmissionRecordDocument): AdmissionRecord

    //special mapping for map to list


}