package SEG3102.HMSPMS.adapters.factories

import SEG3102.HMSPMS.application.dtos.queries.converters.PrescriptionDTOConverter
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.domain.Patient.factories.PrescriptionFactory
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Primary
@Component
class PrescriptionDTOFactory: PrescriptionFactory {
    val dtoConverter: PrescriptionDTOConverter = Mappers.getMapper(PrescriptionDTOConverter::class.java)

    override fun createPrescription(prescription: PrescriptionCreateDTO, presId: String): Prescription {
        return dtoConverter.convertDTO(prescription, presId)
    }

}