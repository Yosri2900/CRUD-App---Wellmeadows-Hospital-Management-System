Feature: Medical Staff Member updates Patient's information
    Scenario: The Medical Staff Member is logged in, Medical Staff Member resubmit
        Given The Medical Staff Member is logged in,
        And Medical Staff Member resubmit
        When the application updatePatientFile is invoked
        Then the application consultPatientFile is invoked
        And Staff Member asks for viewing Patient registration
        And HMS asks for Patient identification number
        And Medical staff member enters Patient identification number
        And HMS shows the Patient registration information
        And Medical staff Member modifies information at will
        And Medical Staff Member resubmit
        And HMS updates Patient registration information
    Scenario: The Medical Staff Member is logged in, Medical Staff Member do not have enough privilee to modify
        Given The Medical Staff Member is logged in,
        And Medical Staff Member do not have enough privilege to modify
        When the application updatePatientFile is invoked
        Then the application consultPatientFile is invoked
        And Staff Member asks for viewing Patient registration
        And HMS asks for Patient identification number
        And Medical staff member enters Patient identification number
        And HMS shows the Patient registration information
        And Medical staff Member modifies information at will
        And Medical Staff Member do not have enough privilege to modify
        And HMS displays modification not allowed error message



