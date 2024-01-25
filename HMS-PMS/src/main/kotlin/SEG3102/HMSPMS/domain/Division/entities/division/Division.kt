package SEG3102.HMSPMS.domain.Division.entities.division

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.entities.room.Room
import java.util.*

class Division(
    var divId: String,
    var divName: String,
    var phoneNumber: String,
//    var doctors: List<String>,
    var chargeNurseUsername: String,
    var availableRooms: MutableMap<Int, Room>,
    var admissionRequests: MutableMap<String, AdmissionRequest>?,
    var admissions: MutableMap<String, AdmissionRecord>?,
    var dischargedPatients: MutableMap<String, AdmissionRecord>?) {

    fun getAvailableRoom(): Room?{
//        return availableRooms.removeFirst()
        val firstKey: Int? = availableRooms.keys.firstOrNull()

        if (firstKey!=null){
            val room = availableRooms[firstKey]
//            availableRooms.remove(firstKey)
            return room
        }

        return null
    }

    fun getAvailableBed(room: Room?): Int?{
//        return room.availableBeds.removeFirst();

        val bed = room?.availableBeds?.firstOrNull()
        room?.availableBeds?.remove(bed)
        return bed
    }
}