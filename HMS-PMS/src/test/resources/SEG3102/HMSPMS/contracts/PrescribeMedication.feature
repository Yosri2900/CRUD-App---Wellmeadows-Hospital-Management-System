Feature: Doctor prescribes medication to patient via HMS
    Scenario: The Doctor is logged in, doctor asks to add a prescription to the selected patient, doctor enters required information
        Given The Doctor is logged in
        And doctor asks to add a prescription to the selected patient
        And doctor enters required information
        When the application prescribeMedication is invoked
        Then Include use case Consult file
        And doctor asks to add a prescription to the selected patient
        And HMS asks for required information
        And Doctor enters required information
        And HMS records prescription in Patient's file
    Scenario: The Doctor is logged in, doctor asks to add a prescription to the selected patient, doctor enters incorrect information
        Given The Doctor is logged in
        And doctor asks to add a prescription to the selected patient
        And doctor enters required information
        When the application prescribeMedication is invoked
        Then Include use case Consult file
        And doctor asks to add a prescription to the selected patient
        And HMS asks for required information
        And Doctor enters incorrect information
        And HMS display incorrect prescription error message
    Scenario: The Doctor is logged in, Selected patient is not one of the doctor's
        Given The Doctor is logged in
        And selected patient is not one of the doctor's
        And doctor enters required information
        When the application prescribeMedication is invoked
        Then Include use case Consult file
        And selected patient is not one of the doctor's
        And HMS notifies doctor that patient is not hers












