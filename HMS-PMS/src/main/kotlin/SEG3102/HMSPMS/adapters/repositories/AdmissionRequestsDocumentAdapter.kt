package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.AdmissionRequestsDocumentConverter
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionRequestsRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.RequestsMongoRepository
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AdmissionRequestsDocumentAdapter(val admissionsMongoRepo: RequestsMongoRepository): AdmissionRequestsRepository {
    val converter = Mappers.getMapper(AdmissionRequestsDocumentConverter::class.java)

    override fun findPatientRequest(patientId: String): AdmissionRequest? {
        val doc = admissionsMongoRepo.findByIdOrNull(patientId)
        return doc?.let { converter.convertToModel(it) }
    }

    override fun save(request: AdmissionRequest): AdmissionRequest {
        val doc = converter.convertToDoc(request)
        admissionsMongoRepo.save(doc)
        return request
    }

    override fun remove(request: AdmissionRequest): Boolean {
        admissionsMongoRepo.deleteById(request.patId)
        return true
    }
}