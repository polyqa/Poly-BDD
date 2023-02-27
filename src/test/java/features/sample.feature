Feature: Career Page Testing
@career
  Scenario: Create career page
    Given validating landing page title
    And click career button
    When validate career page title
    And click see current job
    Then input job keyword
    And click search button
