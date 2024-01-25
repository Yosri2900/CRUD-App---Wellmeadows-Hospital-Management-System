package SEG3102.HMSPMS.domain.Division.entities.request

import java.util.*

class AdmissionRequest(
    val patId: String,
    val divId: String,
    val rationale: String,
    val priority: Int,
    val requestDate: String
) {}