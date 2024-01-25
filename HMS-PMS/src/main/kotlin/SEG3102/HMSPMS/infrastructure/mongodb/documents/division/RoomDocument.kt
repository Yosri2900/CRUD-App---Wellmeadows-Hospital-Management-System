package SEG3102.HMSPMS.infrastructure.mongodb.documents.division

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("rooms")
data class RoomDocument(@Id val roomNumber: Int,
                        val  availableBeds: List<Int>){}