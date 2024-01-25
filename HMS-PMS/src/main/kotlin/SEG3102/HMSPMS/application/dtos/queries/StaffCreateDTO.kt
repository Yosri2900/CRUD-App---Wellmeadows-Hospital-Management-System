package SEG3102.HMSPMS.dtos.queries

import java.util.*

data class StaffCreateDTO(
        val firstName: String,
        val lastName: String,
        val jobTitle: String,
        val email: String,
        val username: String
)
