package SEG3102.HMSPMS.infrastructure.configuration

import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRecordDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.AdmissionRequestDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.DivisionDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.division.RoomDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.NokDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.PatientAccountDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.patient.PrescriptionDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffAccountDocument
import SEG3102.HMSPMS.infrastructure.mongodb.documents.staff.StaffDocument
import SEG3102.HMSPMS.infrastructure.mongodb.repos.DivisionMongoRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.PatientsMongoRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.AccountsMongoRepository
import SEG3102.HMSPMS.infrastructure.mongodb.repos.StaffMongoRepository
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class MongoConfig(val staffAccountRepository: StaffMongoRepository,
                  val patientsMongoRepository: PatientsMongoRepository,
                  val accountsMongoRepository: AccountsMongoRepository,
                  val staffMongoRepository: StaffMongoRepository,
                  val divisionMongoRepository: DivisionMongoRepository,
                  private val encoder: PasswordEncoder
) {

    init {
        //div 1
        val room1 = RoomDocument(1, listOf(1, 2, 3, 4))
        val room2 = RoomDocument(2, listOf(1, 2, 3, 4))
        val room3 = RoomDocument(3, listOf(1, 2, 3, 4))

        //div 2
        val room4 = RoomDocument(4, listOf(1, 2, 3, 4))
        val room5 = RoomDocument(5, listOf(1, 2, 3, 4))
        val room6 = RoomDocument(6, listOf(1, 2, 3, 4))

        //div 3
        val room7 = RoomDocument(7, listOf(1, 2, 3, 4))
        val room8 = RoomDocument(8, listOf(1, 2, 3, 4))
        val room9 = RoomDocument(9, listOf(1, 2, 3, 4))

        val mapOfRooms1 = mutableMapOf<Int, RoomDocument>(
            1 to room1,
            2 to room2,
            3 to room3,
        )

        val mapOfRooms2 = mutableMapOf<Int, RoomDocument>(
            4 to room4,
            5 to room5,
            6 to room6
        )

        val mapOfRooms3 = mutableMapOf<Int, RoomDocument>(
            7 to room7,
            8 to room8,
            9 to room9
        )

        addDivision(DivisionDocument("1", "d1", "554", "jen", mapOfRooms1,
            mutableMapOf<String, AdmissionRequestDocument>(), mutableMapOf<String, AdmissionRecordDocument>(),
            mutableMapOf<String, AdmissionRecordDocument>()))
        addDivision(DivisionDocument("2", "d2", "664", "jen", mapOfRooms2,
            mutableMapOf<String, AdmissionRequestDocument>(), mutableMapOf<String, AdmissionRecordDocument>(),
            mutableMapOf<String, AdmissionRecordDocument>()))
        addDivision(DivisionDocument("3", "d3", "774", "jen", mapOfRooms3,
            mutableMapOf<String, AdmissionRequestDocument>(), mutableMapOf<String, AdmissionRecordDocument>(),
            mutableMapOf<String, AdmissionRecordDocument>()))

        //dummy staff
        addStaffAccount(
            StaffAccountDocument("jen", "jen", "jen", "jen@ex.com", encoder.encode("jen"),
            "Charge Nurse", true)
        )
        addStaff(StaffDocument("jen", "jen", "jen", "jen@ex.com", "Charge Nurse"))

        addStaffAccount(StaffAccountDocument("doc1", "josh", "giddey", "doc1@ex.com", encoder.encode("jen"),
            "Doctor", true))
        addStaff(StaffDocument("doc1", "josh", "giddey", "doc1@ex.com", "Doctor"))


        //dummy patient
        addPatient(
            PatientAccountDocument("123", "patrick", "jenkins", "pat@ex.com",
            "111", "myAd", "M", "single", "doc1@ex.com",
                NokDocument("harris", "uncle", "my st", "2222"),
                mutableMapOf<String, PrescriptionDocument>())
        )

        addPatient(
            PatientAccountDocument("246", "morris", "jenkins", "pat2@ex.com",
                "111", "myAd", "M", "single", "doc1@ex.com",
                NokDocument("john", "uncle", "my st 3", "77777"),
                mutableMapOf<String, PrescriptionDocument>())
        )

    }

//    private fun createCollectionIfNotExists(mongoTemplate: MongoTemplate, collectionName: String) {
//        if (!mongoTemplate.collectionExists(collectionName)) {
//            mongoTemplate.createCollection(collectionName, CollectionOptions.empty())
//        }
//    }

    private fun addDivision(division: DivisionDocument) {
        if (!divisionMongoRepository.existsById(division.divId)) {
            divisionMongoRepository.save(division)
        }
    }

    private fun addStaff(staffDocument: StaffDocument) {
        if (!staffMongoRepository.existsById(staffDocument.username)){
            staffAccountRepository.save(staffDocument)
        }
    }

    private fun addStaffAccount(staffAccountDocument: StaffAccountDocument) {
        if (!accountsMongoRepository.existsById(staffAccountDocument.username)) {
            accountsMongoRepository.save(staffAccountDocument)
        }
    }

    private fun addPatient(patientAccountDocument: PatientAccountDocument) {
        if (!patientsMongoRepository.existsById(patientAccountDocument.id)) {
            patientsMongoRepository.save(patientAccountDocument)
        }
    }
}