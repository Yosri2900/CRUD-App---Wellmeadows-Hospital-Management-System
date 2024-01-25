package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.AdmissionsDocumentConverter
import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionsRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.AdmissionsMongoRepository
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AdmissionsDocumentAdapter(val admRecordRepo: AdmissionsMongoRepository): AdmissionsRepository {
    private val converter = Mappers.getMapper(AdmissionsDocumentConverter::class.java)

    override fun find(patientId: String): AdmissionRecord? {
        val admRecordDoc = admRecordRepo.findByIdOrNull(patientId)
        return admRecordDoc?.let { converter.convertToModel(it) }
    }

    override fun save(admInfo: AdmissionRecord): AdmissionRecord {
        val admDoc = converter.convertToDoc(admInfo)
        admRecordRepo.save(admDoc)
        return admInfo
    }

    override fun remove(admInfo: AdmissionRecord): Boolean {
        println("exisit "+admRecordRepo.existsById(admInfo.patId))
        admRecordRepo.deleteById(admInfo.patId)
        println("exisit "+admRecordRepo.existsById(admInfo.patId))
        if (admRecordRepo.existsById(admInfo.patId)){
            return false
        }
        return false

    }
}