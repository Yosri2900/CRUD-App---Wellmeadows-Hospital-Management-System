package SEG3102.HMSPMS.domain.Patient.entities.prescription

import java.util.*

class Prescription (
        val presId: String,
        val presName: String,
        val unitsPerDay: Int,
        val numAdmPerDay: Int,
        val adminTimeAndNumUnitsRecord: String,
    val admMethod: String,
        val startDate: String,
        val endDate: String
)