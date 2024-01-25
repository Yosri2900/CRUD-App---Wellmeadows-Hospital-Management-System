package SEG3102.HMSPMS.infrastructure.mongodb.documents.division

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("divisions")
data class DivisionDocument(@Id val divId: String,
                            var divName: String,
                            var phoneNumber: String,
                            var chargeNurseUsername: String,
                            var availableRooms: MutableMap<Int, RoomDocument>,
                            var admissionRequests: MutableMap<String, AdmissionRequestDocument>,
                            var admissions: MutableMap<String, AdmissionRecordDocument>,
                            var dischargedPatients: MutableMap<String, AdmissionRecordDocument>){}