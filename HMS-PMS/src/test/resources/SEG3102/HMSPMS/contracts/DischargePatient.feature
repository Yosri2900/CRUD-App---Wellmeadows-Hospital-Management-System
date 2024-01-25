Feature: Charge Nurse discharges patient
    Scenario: The Charge Nurse is logged in
        Given The Charge Nurse is logged in
        When the application dischargePatient is invoked
        Then the application consultFile is invoked
        And Charge Nurse selects to discharge patient
        And HMS updates bed availability
        And HMS prints discharge information



