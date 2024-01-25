package SEG3102.HMSPMS.infrastructure.mongodb.documents.patient

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("noks")
data class NokDocument(
    @Id val name: String,
    val relationshipToPatient: String,
    val address: String,
    val phoneNumber: String
) {
}