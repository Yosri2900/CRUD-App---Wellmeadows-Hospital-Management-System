package SEG3102.HMSPMS.domain.Division.facade.implementation

import SEG3102.HMSPMS.application.services.DomainEventEmitter
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.entities.room.Room
import SEG3102.HMSPMS.domain.Division.events.NewAdmittedPatient
import SEG3102.HMSPMS.domain.Division.events.NewRequestAdded
import SEG3102.HMSPMS.domain.Division.events.PatientDischarged
import SEG3102.HMSPMS.domain.Division.facade.DivisionFacade
import SEG3102.HMSPMS.domain.Division.factories.AdmissionFactory
import SEG3102.HMSPMS.domain.Division.factories.RequestsFactory
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionRequestsRepository
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionsRepository
import SEG3102.HMSPMS.domain.Division.repositories.DischargedPatientsRepository
import SEG3102.HMSPMS.domain.Division.repositories.DivisionRepository
import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import java.util.*

class DivisionFacadeImpl (
    var admissionFactory: AdmissionFactory,
    var admissionRepo: AdmissionsRepository,
    var requestsFactory: RequestsFactory,
    var dischargedPatientsRepo: DischargedPatientsRepository,
    var admissionRequestsRepository: AdmissionRequestsRepository,
    var divRepository: DivisionRepository,
    private var domainEventEmitter: DomainEventEmitter
) : DivisionFacade {


    override fun admitPatient(staffUsername: String, patientId: String, roomNumber: Int?, bed: Int?,
                              admissionRequest: AdmissionRequest, doctorId: String, privInsNum: String?):
            Boolean {
        var divId = admissionRequest.divId
        var div = divRepository.find(divId)

        if (div!=null && div.chargeNurseUsername==staffUsername && div.availableRooms.isNotEmpty()){
            var availableRoom: Room?
            var avRoomNumber : Int
            var avBedNumber : Int
            println("admitPatient() - DivisionFacadeImpl class")

            if (roomNumber!=null && bed!=null){
                availableRoom = div.availableRooms[roomNumber]
                if (availableRoom!=null && availableRoom.availableBeds.contains(bed)){
                    availableRoom.availableBeds.remove(bed)

                    if (availableRoom.availableBeds.isEmpty()){
                        div.availableRooms.remove(roomNumber)
                    }
                    else {
                        div.availableRooms[roomNumber] = availableRoom
                    }

                    avRoomNumber = roomNumber
                    avBedNumber = bed
                }
                else return false

                //Maybe change later

            }
            else {
                availableRoom = div.getAvailableRoom()

                if (availableRoom != null) {
                    avRoomNumber = availableRoom.roomNumber
                }
                else avRoomNumber = -1


                avBedNumber = div.getAvailableBed(availableRoom)!!
                if (availableRoom!=null && availableRoom.availableBeds.isEmpty()) {
                    div.availableRooms.remove(availableRoom.roomNumber)
                }
            }

            var admissionRecord = admissionFactory.createAdmission(divId, privInsNum, avBedNumber,
                avRoomNumber, patientId,
                admissionRequest, doctorId)
            admissionRepo.save(admissionRecord)

            div.admissions?.set(admissionRecord.patId, admissionRecord)
            div.admissionRequests?.remove(admissionRequest.patId)
            admissionRequestsRepository.remove(admissionRequest)
            divRepository.save(div)
            admissionRepo.save(admissionRecord)
            domainEventEmitter.emit(NewAdmittedPatient(UUID.randomUUID().toString(),
                admissionRecord.patId,
                Date().toString()))
            return true
        }


        return false
    }

    override fun addRequest(patID: String, staffUsername: String, requestInfo: RequestCreateDTO): Boolean {
        var div = divRepository.find(requestInfo.divId)
        println(div)

        if (div!=null && div.chargeNurseUsername==staffUsername){
            var request = requestsFactory.createRequest(requestInfo)
            println("div is not null")

            div.admissionRequests?.set(request.patId, request)
            admissionRequestsRepository.save(request)
            divRepository.save(div)
            domainEventEmitter.emit(NewRequestAdded(UUID.randomUUID().toString(),
            request.patId,
            Date().toString
            ()))

            return true
        }
        println("returned false")
        return false
    }

    override fun admitPatientFromRequestList(
        patId: String,
        divId: String,
        staffUsername: String,
        doctorId: String,
        roomNumber: Int?,
        bedNumber: Int?,
        privInsNum: String?
    ):
            Boolean {
        val div = divRepository.find(divId)

        if (div!=null) {
            val request = div.admissionRequests?.get(patId)
            if (request != null) {
                return admitPatient(staffUsername, patId, roomNumber, bedNumber, request, doctorId, privInsNum)
            }
        }
        return false
    }

    override fun dischargePatient(patId: String, divId: String, currUser: String): Boolean {
        var div = divRepository.find(divId)

        if (div!=null && div.chargeNurseUsername == currUser) {
            println("charge nurse corresponds")
            var admRecord = div.admissions?.get(patId)

            if (admRecord!=null){
                var roomNumber = admRecord.roomNumber
                var bedNumber = admRecord.bedNumber

                var roomObject = div.availableRooms[roomNumber]

                if (roomObject!=null){
                    roomObject.availableBeds.add(bedNumber)
                }
                else {
                    roomObject = Room(roomNumber, setOf<Int>(bedNumber) as MutableSet<Int>)
                }
                div.availableRooms[roomNumber] = roomObject
                admissionRepo.remove(admRecord)
                dischargedPatientsRepo.save(admRecord)
                div.dischargedPatients?.set(admRecord.patId, admRecord)
                div.admissions?.remove(patId)
                divRepository.save(div)
                dischargedPatientsRepo.save(admRecord)
                domainEventEmitter.emit(
                    PatientDischarged(admRecord.patId,
                    admRecord.patId,
                    Date())
                )
                return true
            }
            else {return false}

        }
        return false
    }

}