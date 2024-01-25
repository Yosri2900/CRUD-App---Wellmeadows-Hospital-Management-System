Feature: Medical Staff Member registers patient to HMS 
    Scenario: The medical staff member is logged in, Medical Staff Member enters requested information
        Given: The medical staff member is logged in
        When the application registerPatient is invoked
        Then Medical Staff Member enters requested information
        And HMS registers Patient
    Scenario: The medical staff member is logged in, Medical Staff Member enters incomplete information
        Given: The medical staff member is logged in
        And Medical Staff Member enters incomplete information
        When the application registerPatient is invoked
        Then Medical Staff Member asks for new Patient registration
        And HMS asks for Patient's information
        And Medical Staff Member enters incomplete
        And HMS displays incomplete information error message





