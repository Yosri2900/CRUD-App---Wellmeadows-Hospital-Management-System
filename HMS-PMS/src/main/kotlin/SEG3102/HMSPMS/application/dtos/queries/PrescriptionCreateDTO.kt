package SEG3102.HMSPMS.dtos.queries

import java.util.*

data class PrescriptionCreateDTO(
    val presName: String,
    val unitsPerDay: Int,
    val numAdmPerDay: Int,
    val adminTimeAndNumUnitsRecord: String,
    val admMethod: String,
    val startDate: String,
    val endDate: String
)