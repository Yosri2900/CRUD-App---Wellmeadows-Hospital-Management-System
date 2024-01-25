package SEG3102.HMSPMS.infrastructure.mongodb.documents.logs

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("logs")
data class LogDocument(@Id val id: String,
val message: String){

}