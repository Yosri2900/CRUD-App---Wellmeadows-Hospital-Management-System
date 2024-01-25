package SEG3102.HMSPMS.tests.config

import SEG3102.HMSPMS.contracts.testStubs.repositories.*
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionRequestsRepository
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionsRepository
import SEG3102.HMSPMS.domain.Division.repositories.DischargedPatientsRepository
import SEG3102.HMSPMS.domain.Division.repositories.DivisionRepository
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import SEG3102.HMSPMS.domain.Patient.repositories.PrescriptionsRepository
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TestBeanConfiguration {

    @Bean
    fun admissionRequestsRepository() :AdmissionRequestsRepository {
        return AdmissionRequestsRepositoryStub()
    }

    @Bean
    fun admissionsRepository(): AdmissionsRepository {
        return AdmissionsRepositoryStub()
    }

    @Bean
    fun dischargedPatientsRepository() : DischargedPatientsRepository {
        return DischargedPatientsRepositoryStub()
    }

    @Bean
    fun divisionRepository() : DivisionRepository {
        return DivisionRepositoryStub()
    }

    @Bean
    fun patientRepository(): PatientRepository {
        return PatientRepositoryStub()
    }

    @Bean
    fun prescriptionsRepository(): PrescriptionsRepository {
        return PrescriptionsRepositoryStub()
    }

    @Bean
    fun staffRepository() : StaffRepository {
        return StaffRepositoryStub()
    }

}