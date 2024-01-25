package SEG3102.HMSPMS.dtos.queries

data class DivisionCreateDTO(
        val divisionName: String,
        val phoneNumber: String,
        val chargeNurseUsername: String,
        val numOfBeds: Int
)
