package SEG3102.HMSPMS.domain.Division.factories

import SEG3102.HMSPMS.dtos.queries.RequestCreateDTO
import SEG3102.HMSPMS.domain.Division.entities.request.AdmissionRequest

interface RequestsFactory {
    fun createRequest(reqInfo: RequestCreateDTO): AdmissionRequest
}