Feature: Staff member (nurses, doctors, medicual directors, or personnel officers) register themselves to Hospital Management System (HMS)
    Scenario: The HMS is ON, Staff Member provides complete information to HMS
        Given the HMS is ON
        And the Staff Member provides complete information to HMS
        When the application command registerStaff is invoked
        Then Staff Member selects to register
        And HMS system asks Staff Member for information
        And Staff Member provides all the required information
        And HMS displays an acknowledgement message
    Scenario: The HMS is ON, Staff Member provides Incomplete information to HMS
        Given the HMS is ON
        And the Staff Member provides Incomplete information to HMS
        When the application command registerStaff is invoked
        Then Staff Member selects to register
        And Staff Member provides incomplete information
        And HMS displays an incomplete information error message
    Scenario: The HMS is ON, User not found in the system
        Given the HMS is ON
        And User is not found in the system
        When the application command registerStaff is invoked
        Then Staff Member selects to register
        And User is not found in the System
        And HMS displays an invalid user error message







