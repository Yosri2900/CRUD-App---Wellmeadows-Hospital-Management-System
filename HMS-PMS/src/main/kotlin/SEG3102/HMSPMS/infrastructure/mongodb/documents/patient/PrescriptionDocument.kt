package SEG3102.HMSPMS.infrastructure.mongodb.documents.patient

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("prescriptions")
data class PrescriptionDocument(@Id val presId: String,
                                val presName: String,
                                val unitsPerDay: Int,
                                val numAdmPerDay: Int,
                                val adminTimeAndNumUnitsRecord: String,
                                val admMethod: String,
                                val startDate: String,
                                val endDate: String
) {

}