package SEG3102.HMSPMS.infrastructure.mongodb.documents.division

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("admissionRecords")
data class AdmissionRecordDocument(@Id var patId: String,
                                   var divId: String,
                                   var privInsNum: String?,
                                   var roomNumber: Int,
                                   var bedNumber: Int,
                                   var localDoctorId: String,
                                   var admissionDate: String,
                                   var dischargeDate: String?){}