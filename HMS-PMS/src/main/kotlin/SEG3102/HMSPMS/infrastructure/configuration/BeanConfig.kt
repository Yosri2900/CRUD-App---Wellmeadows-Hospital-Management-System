package SEG3102.HMSPMS.infrastructure.configuration

import SEG3102.HMSPMS.application.services.DomainEventEmitter
import SEG3102.HMSPMS.application.usecases.*
import SEG3102.HMSPMS.application.usecases.implementation.PatientAdmissionImpl
import SEG3102.HMSPMS.application.usecases.implementation.RegisterPatientImpl
import SEG3102.HMSPMS.application.usecases.implementation.RegisterStaffImpl
import SEG3102.HMSPMS.application.usecases.implementation.UpdatePatientFileImpl
import SEG3102.HMSPMS.application.usecases.implementation.AdmitPatientFromRequestListImpl
import SEG3102.HMSPMS.application.usecases.implementation.DischargePatientImpl
import SEG3102.HMSPMS.application.usecases.implementation.PrescribeMedicationImpl
import SEG3102.HMSPMS.application.usecases.implementation.RequestPatientAdmissionImpl
import SEG3102.HMSPMS.domain.Division.facade.DivisionFacade
import SEG3102.HMSPMS.domain.Division.facade.implementation.DivisionFacadeImpl
import SEG3102.HMSPMS.domain.Division.factories.AdmissionFactory
import SEG3102.HMSPMS.domain.Division.factories.RequestsFactory
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionRequestsRepository
import SEG3102.HMSPMS.domain.Division.repositories.AdmissionsRepository
import SEG3102.HMSPMS.domain.Division.repositories.DischargedPatientsRepository
import SEG3102.HMSPMS.domain.Division.repositories.DivisionRepository
import SEG3102.HMSPMS.domain.Log.facade.LogFacade
import SEG3102.HMSPMS.domain.Log.facade.implementation.LogFacadeImpl
import SEG3102.HMSPMS.domain.Log.factories.LogFactory
import SEG3102.HMSPMS.domain.Log.repositories.LogsRepo
import SEG3102.HMSPMS.domain.Patient.facade.Implementation.PatientFacadeImpl
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import SEG3102.HMSPMS.domain.Patient.factories.PrescriptionFactory
import SEG3102.HMSPMS.domain.Patient.factory.PatientFactory
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import SEG3102.HMSPMS.domain.Patient.repositories.PrescriptionsRepository
import SEG3102.HMSPMS.domain.Staff.facade.StaffFacade
import SEG3102.HMSPMS.domain.Staff.facade.implementation.StaffFacadeImpl
import SEG3102.HMSPMS.domain.Staff.factories.StaffFactory
import SEG3102.HMSPMS.domain.Staff.repositories.StaffRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeanConfig {

    //Staff

    // -- Use cases
    @Bean
    fun registerStaffUseCase(staffFacade: StaffFacade): RegisterStaff {
        return RegisterStaffImpl(staffFacade);
    }

    //Patient

    // -- Use cases

    @Bean
    fun registerPatientUseCase(staffFacade: StaffFacade,
                               patientFacade: PatientFacade): RegisterPatient{
        return RegisterPatientImpl(staffFacade, patientFacade);
    }

    @Bean
    fun updatePatientFileUseCase(patientFacade: PatientFacade, staffFacade: StaffFacade): UpdatePatientFile {
        return UpdatePatientFileImpl(patientFacade, staffFacade)
    }

    @Bean
    fun prescribeMedicationUseCase(staffFacade: StaffFacade,
                                   patientFacade: PatientFacade, logFacade: LogFacade): PrescribeMedication {
        return PrescribeMedicationImpl(staffFacade, patientFacade, logFacade)
    }

    //Division

    // -- Use cases

    @Bean
    fun dischargePatientUseCase(divisionFacade: DivisionFacade, staffFacade: StaffFacade,
                                patientFacade: PatientFacade, logFacade: LogFacade): DischargePatient {
        return DischargePatientImpl(divisionFacade, staffFacade, patientFacade, logFacade)
    }
    @Bean
    fun patientAdmissionUseCase(divisionFacade: DivisionFacade,
                                patientFacade: PatientFacade): PatientAdmission {
        return PatientAdmissionImpl(patientFacade, divisionFacade)
    }

    @Bean
    fun requestPatientAdmissionUseCase(divisionFacade: DivisionFacade, staffFacade: StaffFacade,
                                       patientFacade: PatientFacade): RequestPatientAdmission {
        return RequestPatientAdmissionImpl(divisionFacade, staffFacade, patientFacade)
    }

    @Bean
    fun admitFromRequestUseCase(divisionFacade: DivisionFacade, staffFacade: StaffFacade,
                                patientFacade: PatientFacade, logFacade: LogFacade): AdmitPatientFromRequestList {
        return AdmitPatientFromRequestListImpl(divisionFacade, staffFacade, patientFacade, logFacade)
    }

    //Logs

    // -- Facade
    @Bean
    fun getStaffFacade(staffRepository: StaffRepository,
                       staffFactory: StaffFactory,
                       patientRepository: PatientRepository,
                       domainEventEmitter: DomainEventEmitter): StaffFacade {
        return StaffFacadeImpl(staffRepository, staffFactory, domainEventEmitter)
    }

    @Bean
    fun getPatientFacade(patientRepository: PatientRepository,
                         patientFactory: PatientFactory,
                         presFactory: PrescriptionFactory,
                         presRepo: PrescriptionsRepository,
                         domainEventEmitter: DomainEventEmitter
    ): PatientFacade {
        return PatientFacadeImpl(patientRepository, patientFactory, presFactory, presRepo, domainEventEmitter)
    }

    @Bean
    fun getDivisionFacade(admissionFactory: AdmissionFactory,
                          admissionRepo: AdmissionsRepository,
                          requestsFactory: RequestsFactory,
                          dischargedPatientsRepo: DischargedPatientsRepository,
                          admissionRequestsRepository: AdmissionRequestsRepository,
                          divRepository: DivisionRepository,
                          domainEventEmitter: DomainEventEmitter): DivisionFacade {
        return DivisionFacadeImpl(admissionFactory, admissionRepo, requestsFactory, dischargedPatientsRepo,
            admissionRequestsRepository, divRepository, domainEventEmitter)
    }
    //T0 BE completed
    @Bean
    fun getLogFacade(logFactory: LogFactory, logsRepo: LogsRepo): LogFacade{
        return LogFacadeImpl(logFactory, logsRepo)
    }

}