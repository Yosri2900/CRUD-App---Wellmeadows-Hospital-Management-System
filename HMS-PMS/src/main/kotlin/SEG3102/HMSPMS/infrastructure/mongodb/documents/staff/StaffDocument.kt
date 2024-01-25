package SEG3102.HMSPMS.infrastructure.mongodb.documents.staff

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("staff")
data class StaffDocument(
    @Id var username: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var jobTitle: String
){}