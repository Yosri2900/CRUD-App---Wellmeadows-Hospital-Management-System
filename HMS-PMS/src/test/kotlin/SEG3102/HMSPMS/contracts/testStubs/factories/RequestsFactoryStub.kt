package SEG3102.HMSPMS.contracts.testStubs.factories

import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest
import SEG3102.HMSPMS.domain.Division.factories.RequestsFactory
import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import java.util.Date
import java.util.UUID

class RequestsFactoryStub : RequestsFactory {
    override fun createRequest(reqInfo: RequestCreateDTO): AdmissionRequest {
        return AdmissionRequest(
                reqInfo.patId,
                reqInfo.divId,
                reqInfo.rationale,
                reqInfo.priority,
                reqInfo.requestDate
        )
    }
}