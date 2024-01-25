package SEG3102.HMSPMS.infrastructure.mongodb.documents.division

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("dischargeRecords")
data class DischargeRecordDocument (@Id var patId: String,
                                   var privInsNum: String?,
                                   var roomNumber: Int,
                                   var bedNumber: Int,
                                   var localDoctorId: String,
                                   var admissionDate: String,
                                   var dischargeDate: String?){}