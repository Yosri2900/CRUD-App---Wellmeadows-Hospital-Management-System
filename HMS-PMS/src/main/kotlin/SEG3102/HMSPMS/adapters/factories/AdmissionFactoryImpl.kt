package SEG3102.HMSPMS.adapters.factories

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.factories.AdmissionFactory
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.util.*

@Primary
@Component
class AdmissionFactoryImpl: AdmissionFactory {
    override fun createAdmission(
        divId: String,
        privInsNum: String?,
        bed: Int,
        room: Int,
        patId: String,
        admReq: AdmissionRequest?,
        doctorId: String
    ): AdmissionRecord {
        return AdmissionRecord(patId, privInsNum, divId, room, bed, doctorId, Date().toString(), null)
    }

}