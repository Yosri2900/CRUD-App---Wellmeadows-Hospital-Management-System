package SEG3102.HMSPMS.domain.Division.entities.room

class Room (
    val roomNumber: Int,
    val availableBeds: MutableSet<Int>
//    val occupiedBeds: MutableList<Int>
)