package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.DischargedPatientsDocumentConverter
import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.repositories.DischargedPatientsRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.DischargedPatientsMongoRepository
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DischargedPatientsDocumentAdapter(val dischargedPatientsMongoRepo: DischargedPatientsMongoRepository):
    DischargedPatientsRepository {
    private val converter = Mappers.getMapper(DischargedPatientsDocumentConverter::class.java)

    override fun find(patientID: String): AdmissionRecord? {
        val dischargedPatient = dischargedPatientsMongoRepo.findByIdOrNull(patientID)
        return dischargedPatient?.let { converter.convertToModel(it) }
    }

    override fun save(admRecord: AdmissionRecord): AdmissionRecord {
        val doc =  converter.convertToDoc(admRecord)
        dischargedPatientsMongoRepo.save(doc)
        return admRecord
    }
}