package SEG3102.HMSPMS.adapters.repositories

import SEG3102.HMSPMS.adapters.repositories.converters.PatientAccountsDocumentsConverter
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.PatientsMongoRepository
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PatientAccountDocumentAdapter(val patientsMongoRepo: PatientsMongoRepository): PatientRepository {
    private val converter = Mappers.getMapper(PatientAccountsDocumentsConverter::class.java)

    override fun find(patientId: String): PatientAccount? {
        val patDoc = patientsMongoRepo.findByIdOrNull(patientId)
        return patDoc?.let { converter.convertToModel(it) }
    }

    override fun savePatient(patient: PatientAccount): PatientAccount {
        val patDoc = converter.convertToDoc(patient)
        patientsMongoRepo.save(patDoc)
        return patient
    }
}