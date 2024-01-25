package SEG3102.HMSPMS.domain.Patient.facade.Implementation

import SEG3102.HMSPMS.application.services.DomainEventEmitter
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.events.NewPrescriptionAdded
import SEG3102.HMSPMS.domain.Patient.events.PatientAccountCreated
import SEG3102.HMSPMS.domain.Patient.facade.PatientFacade
import SEG3102.HMSPMS.domain.Patient.factories.PrescriptionFactory
import SEG3102.HMSPMS.domain.Patient.factory.PatientFactory
import SEG3102.HMSPMS.domain.Patient.repositories.PatientRepository
import SEG3102.HMSPMS.domain.Patient.repositories.PrescriptionsRepository
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.PrescriptionCreateDTO
import java.util.*

class PatientFacadeImpl (
    private var patientRepository: PatientRepository,
    private var patientFactory: PatientFactory,
    private var presFactory: PrescriptionFactory,
    private var presRepo: PrescriptionsRepository,
    private var domainEventEmitter: DomainEventEmitter
) : PatientFacade{

    override fun addPatient(patientInfo: PatientCreateDTO): Boolean {

        var pat = existPatient(patientInfo.id)

        if (pat== null) {
            println("the pat is not found")
            pat = patientFactory.createPatient(patientInfo)
            patientRepository.savePatient(pat)
            domainEventEmitter.emit(PatientAccountCreated(
                UUID.randomUUID().toString(),
                Date().toString(),
                pat.id
            ))
            return true
        }

        return false
    }

    override fun updatePatientInfo(patientAccount: PatientAccount): Boolean {
        patientRepository.savePatient(patientAccount)
        return true
    }

    override fun existPatient(patientId: String): PatientAccount? {
        return patientRepository.find(patientId)
    }

    override fun addPrescription(patientAccount: PatientAccount, pres: PrescriptionCreateDTO): Boolean {

        val prescription = presFactory.createPrescription(pres, UUID.randomUUID().toString())
        patientAccount.prescriptions[prescription.presId] = prescription
        patientRepository.savePatient(patientAccount)
        presRepo.save(prescription)
        domainEventEmitter.emit(NewPrescriptionAdded(UUID.randomUUID().toString(), Date(), patientAccount.doctorEmail))
        return true
    }

}