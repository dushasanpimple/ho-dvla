@dvla
Feature: Check the vehicles  with DVLA and assert on the make and colour of the vehicle which reads from the 
         CSV or XLS file configured in Config file

  Scenario: Verify make and colour of list of Vehicles
    Given I navigate to the dvla page
    And I start the vehicle check
    And I verify all the vehicles in 'verify.filetype' files from the list of files
    Then print out the results to a file
