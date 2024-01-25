package SEG3102.HMSPMS.tests.config.testStubs

import SEG3102.HMSPMS.domain.Division.entities.admission.AdmissionRecord
import SEG3102.HMSPMS.domain.Division.entities.division.Division
import SEG3102.HMSPMS.domain.Division.repositories.DivisionRepository
import java.util.HashMap

class DivisionRepositoryStub : DivisionRepository {
    private val divisionRepo : MutableMap<String, Division> = HashMap()
    override fun find(divisionId: String): Division? {
        return divisionRepo[divisionId]
    }

    override fun save(division: Division): Division? {
        divisionRepo[division.divId] = division
        return division
    }

}