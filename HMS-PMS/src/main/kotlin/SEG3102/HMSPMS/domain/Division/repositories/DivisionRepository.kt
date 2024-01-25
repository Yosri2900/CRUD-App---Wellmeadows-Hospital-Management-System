package SEG3102.HMSPMS.domain.Division.repositories

import SEG3102.HMSPMS.domain.Division.entities.division.Division

interface DivisionRepository {
    fun find(divisionId: String): Division?
    fun save(division: Division): Division?

}