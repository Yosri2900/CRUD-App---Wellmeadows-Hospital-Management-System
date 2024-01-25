package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.PatientAccountDocument
import org.mapstruct.Mapper

@Mapper
interface PatientAccountsDocumentsConverter {
    fun convertToDoc(patientAccount: PatientAccount): PatientAccountDocument

    fun convertToModel(patientAccountDocument: PatientAccountDocument): PatientAccount

//    fun mapPrescriptionListToMap (list: List<Prescription>): MutableMap<String, Prescription> {
//        return list.associateByTo(mutableMapOf()) { it.presId }
//    }

//    fun mapPrescriptionMapToList (map: MutableMap<String, Prescription>): List<PrescriptionDocument>{
//        return map.entries.map { (presId, pres) ->
//            PrescriptionDocument(presId, pres.presName, pres.unitsPerDay,
//                pres.numAdmPerDay, pres.adminTimeAndNumUnitsRecord, pres.admMethod, pres.startDate, pres.endDate)
//        }
//    }


}
