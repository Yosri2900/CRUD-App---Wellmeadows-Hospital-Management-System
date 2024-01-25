Feature: Charge Nurse enters patient into awaiting admission list
    Scenario: The Charge Nurse is logged in, patient registration is being displayed, Charge Nurse provides required information
        Given: The Charge Nurse is logged in
        And patient registration is being displayed
        And Charge Nurse provides required information
        When the application requestPatientInformation is invoked
        Then Charge Nurse chooses to request patient admission
        And HMS asks for the division for which request is to be made as well as additional information
        And Charge Nurse provides required information
        And HMS puts Patient in requested ward list of patients awaiting admission
        And HMS sends jnotification to requested ward Charge Nurse
    Scenario: The Charge Nurse is logged in, patient registration is being displayed, Charge Nurse provides incorrect information
        Given: The Charge Nurse is logged in
        And patient registration is being displayed
        And Charge Nurse provides incorrect information
        When the application requestPatientInformation is invoked
        Then Charge Nurse chooses to request patient admission
        And HMS asks for the division for which request is to be made as well as additional information
        And Charge Nurse provides incorrect information
        And HMS displays information error message
     Scenario: The Charge Nurse is logged in, patient registration is being displayed, Patient is already admitted to a service
        Given: The Charge Nurse is logged in
        And patient registration is being displayed
        And Patient is already admitted to a service
        When the application requestPatientInformation is invoked
        Then Charge Nurse chooses to request patient admission
        And HMS asks for the division for which request is to be made as well as additional information
        And Patient is already admitted to a service
        And HMS displays patient already in ward error message





