package SEG3102.HMSPMS.infrastructure.mongodb.documents.patient

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("patientAccounts")
data class PatientAccountDocument(@Id val id: String,
                                  var firstName: String,
                                  var lastName: String,
                                  var patientEmail: String,
                                  var phoneNumber: String,
                                  var address: String,
                                  var gender: String,
                                  var maritalStatus: String,
                                  var doctorEmail: String,
                                  var nextOfKin: NokDocument?,
                                  var prescriptions: MutableMap<String, PrescriptionDocument>){}