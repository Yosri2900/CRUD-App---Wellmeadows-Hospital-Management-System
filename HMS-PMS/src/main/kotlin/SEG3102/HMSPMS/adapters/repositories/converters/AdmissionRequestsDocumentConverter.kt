package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRequestDocument
import org.mapstruct.Mapper

@Mapper
interface AdmissionRequestsDocumentConverter {
    fun convertToDoc(admissionRequest: AdmissionRequest): AdmissionRequestDocument
    fun convertToModel(admissionRequestDocument: AdmissionRequestDocument): AdmissionRequest

}