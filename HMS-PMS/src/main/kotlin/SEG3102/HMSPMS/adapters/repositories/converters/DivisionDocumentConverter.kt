package SEG3102.HMSPMS.adapters.repositories.converters

import SEG3102.HMSPMS.domain.Division.entities.division.Division
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.DivisionDocument
import org.mapstruct.Mapper


@Mapper
interface DivisionDocumentConverter {
    fun convertToDoc(division: Division): DivisionDocument

    fun convertToModel(divisionDocument: DivisionDocument): Division

//    fun mapRoomMapToList(divRoomMap: MutableMap<Int, Room>): List<RoomDocument>{
//        return divRoomMap.entries.map { (roomId, room) ->
//            RoomDocument(roomId, room.availableBeds.toList())
//        }
//    }
}