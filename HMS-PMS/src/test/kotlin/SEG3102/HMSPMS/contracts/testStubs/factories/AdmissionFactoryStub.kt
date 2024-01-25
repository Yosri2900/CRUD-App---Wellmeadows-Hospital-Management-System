package SEG3102.HMSPMS.contracts.testStubs.factories

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.factories.AdmissionFactory
import java.util.Date
import java.util.UUID

class AdmissionFactoryStub : AdmissionFactory {

    override fun createAdmission(divId: String, privInsNum: String?, bed: Int, room: Int, patId: String, admReq: AdmissionRequest?, doctorId: String): AdmissionRecord {
        TODO("NOT YET IMPLEMENTED")
//        return AdmissionRecord(
//                patId,
//                null,
//                room,
//                bed,
//                doctorId,
//                admReq.requestDate,
//                Date().toString(),
//                Date().toString()
//        )
    }
}