package SEG3102.HMSPMS.adapters.factories

import SEG3102.HMSPMS.domain.Log.entities.Log.LogItem
import SEG3102.HMSPMS.domain.Log.factories.LogFactory
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.util.*

@Primary
@Component
class LogFactoryImpl: LogFactory {
    override fun createLog(id:String, patientInfo: String): LogItem {
        return LogItem(id, patientInfo);
    }
}