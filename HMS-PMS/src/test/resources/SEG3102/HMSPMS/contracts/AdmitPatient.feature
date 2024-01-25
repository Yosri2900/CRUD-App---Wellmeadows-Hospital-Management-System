Feature: Charge Nurse admits a patient via HMS
    Scenario: The Charge Nurse is logged in, Division is not complete
        Given The Charge Nurse is logged in
        When the application admitPatient is invoked
        Then application consultPatientFile is invoked
        And Staff Member asks for viewing Patient registration
        And Medical staff member enters Patient identification number
        And HMS shows the Patient registration information
        And Charge Nurse chooses to admit the patient 
        And Charge Nurse enters room and bed number or alternatively browses through a list of available rooms and beds in the ward and makes a selection
        And HMS admits patient
        And Log File Access
    Scenario: The Charge Nurse is logged in, Division is complete, HMS notifies Charge Nurse that her division is complete
        Given The Charge Nurse is logged in
        And Division is complete
        And HMS notifies Charge Nurse that her division is complete
        When the application admitPatient is invoked
        Then application consultPatientFile is invoked
        And Staff Member asks for viewing Patient registration
        And HMS asks for Patient identification number
        And Medical staff member enters Patient identification number
        And HMS shows the Patient registration information
        And Charge Nurse chooses to admit the patient
        And division is complete
        And HMS notifies Charge Nurse that her division is complete
    Scenario: The Charge Nurse is logged in, Division is complete, HMS gives possibility to request an admission for Patient
        Given The Charge Nurse is logged in
        And Division is complete
        And HMS notifies Charge Nurse that her division is complete
        When the application admitPatient is invoked
        Then application consultPatientFile is invoked
        And Staff Member asks for viewing Patient registration
        And HMS asks for Patient identification number
        And Medical staff member enters Patient identification number
        And HMS shows the Patient registration information
        And Charge Nurse chooses to admit the patient
        And division is complete
        And HMS gives possibility to request an admission for Patient


