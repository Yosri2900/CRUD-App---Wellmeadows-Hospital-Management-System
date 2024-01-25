Feature: Charge Nurse admits patient into system by browsing through patients in request list
    Scenario: The Charge Nurse is logged in, patient is in request list, Nurse Charge performs admission
        Given: The Charge Nurse is logged in
        And patient is in request list
        And Nurse Change performs admission
        When the application admitPatientFromRequestList is invoked
        Then Charge nurse browses through list of patients in request list and select open
        And HMS displays selected Patient registration
        And perform admission as in use case Admit Patient
    Scenario: The Charge Nurse is logged in, patient is in request list, Patient can not be admitted
        Given: The Charge Nurse is logged in
        And patient is in request list
        And Patient cannot be admitted
        When the application admitPatientFromRequestList is invoked
        Then Charge nurse browses through list of patients in request list and select open
        And HMS displays selected Patient registration
        And Patient can not be admitted
        And Charge Nurse denies Patient admission
        And HMS sends notification to Charge Nurse who requested admission









