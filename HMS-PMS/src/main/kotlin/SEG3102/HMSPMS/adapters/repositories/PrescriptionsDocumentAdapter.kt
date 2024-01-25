package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.PrescriptionsDocumentConverter
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.domain.Patient.repositories.PrescriptionsRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.PrescriptionMongoRepository
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PrescriptionsDocumentAdapter(val
                                   prescriptionMongoRepo: PrescriptionMongoRepository
): PrescriptionsRepository {

    private val converter = Mappers.getMapper(PrescriptionsDocumentConverter::class.java)

    override fun find(presId: String): Prescription? {
        val pres =  prescriptionMongoRepo.findByIdOrNull(presId)
        return pres?.let { converter.convertToModel(it) }
    }

    override fun save(prescription: Prescription): Prescription {
        prescriptionMongoRepo.save(converter.convertToDoc(prescription))
        return prescription
    }
}