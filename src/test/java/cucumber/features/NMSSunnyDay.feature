Feature: Pharmacist completes New Medicine Service

  Scenario: NMS Sunny Day scenario
    Given the NMS service is held in the Available Clinical Services section of the EHR
    And RESIP is available
    When the Pharmacist completes the Engagement screen, selects Products from RESIP and saves
    And completes the Intervention screen and saves
    And completes the Follow Up screen
    And selects Service Complete
    Then the NMS is saved
    And appears in the Completed Clinical Service section of the EHR