package SEG3102.HMSPMS.infrastructure.mongodb.documents.division

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("admissionRequests")
data class AdmissionRequestDocument(@Id val patId: String,
                                    val divId: String,
                                    val rationale: String,
                                    val priority: Int,
                                    val requestDate: String){}