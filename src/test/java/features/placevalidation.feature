

Feature: Validating Addplace API
  @AddPlace
  Scenario Outline: Verifying the place is succesfully is added using AddpalceApi
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "AddplaceAPi" using http "POST" request
    Then Api call is success with statuscode 200
    And "status" in response body should be "OK"
    And  "scope" in response body should be "APP"
    And verify palce_Id created which maps to "<name>" using "getplaceAPi"    
    
    Examples:
    |name      |language|address           |
    |HV Enclave|English |Summerwalk Houston|
   # |MI Enclave|Turkish |Countrylane Ankara|
   
   
   @DeletePlace
   Scenario:Verify the delete place functionality
   
    Given Delete payload 
    When user calls "deletepalceAPi" using http "POST" request
    Then Api call is success with statuscode 200
    And "status" in response body should be "OK"