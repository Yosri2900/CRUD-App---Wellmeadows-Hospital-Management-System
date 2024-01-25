package SEG3102.HMSPMS.contracts.testStubs.factories

import SEG3102.HMSPMS.domain.Patient.entities.nextofkin.NextOfKin
import SEG3102.HMSPMS.domain.Patient.entities.patient.PatientAccount
import SEG3102.HMSPMS.domain.Patient.entities.prescription.Prescription
import SEG3102.HMSPMS.domain.Patient.factory.PatientFactory
import SEG3102.HMSPMS.dtos.queries.PatientCreateDTO
import SEG3102.HMSPMS.dtos.queries.StaffCreateDTO
import java.util.*

class PatientFactoryStub : PatientFactory{

    override fun createPatient(patient: PatientCreateDTO): PatientAccount {
            return PatientAccount(
                    patient.id,
                    patient.firstName,
                    patient.lastName,
                    patient.patientEmail,
                    patient.phoneNumber,
                    patient.address,
                    patient.gender,
                    patient.maritalStatus,
                    patient.doctorEmail!!,
                    patient.nextOfKin?.let {
                        NextOfKin(it.name,
                                patient.nextOfKin!!.relationshipToPatient,
                                patient.nextOfKin!!.address,
                                patient.nextOfKin!!.phoneNumber)
                    },
                    mutableMapOf<String, Prescription>()
            )
    }

}