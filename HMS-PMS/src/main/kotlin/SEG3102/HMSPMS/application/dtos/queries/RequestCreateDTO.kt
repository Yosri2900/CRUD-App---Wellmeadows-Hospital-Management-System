package SEG3102.HMSPMS.dtos.queries

import java.util.*

data class RequestCreateDTO(
 var rationale: String,
 var priority: Int,
 var divId: String,
 var patId: String,
var requestDate: String)
