package SEG3102.HMSPMS.domain.Log.events

import SEG3102.HMSPMS.domain.common.DomainEvent
import java.util.*

class NewLogAdded(val id: String,
                  val patInfo: String,
                  val logDate: Date): DomainEvent {
}