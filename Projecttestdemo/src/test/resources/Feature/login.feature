Feature: 

  @smoke
  Scenario Outline: Test login with valid cred.
    Given enter the URl
    And login with valid <username> and <password>
    When click on submit button
    Then navigate to home page

    Examples: 
      | username | password |
      | amit     |    12345 |

  @sanity
  Scenario Outline: Test login with invalid cred.
    Given enter the URl
    And login with invalid <username> and <password>
    When click on submit button
    Then navigate to home page

    Examples: 
      | username | password |
      | sumit    |   123456 |

  @Regression
  Scenario Outline: Test login with valid cred.
    Given enter the URl
    And login with valid <username> and <password>
    When click on submit button
    Then navigate to home page

    Examples: 
      | username  | password |
      | shobhakar |    12345 |

  @smoke @sanity
  Scenario Outline: Test login with invalid cred.
    Given enter the URl
    And login with invalid <username> and <password>
    When click on submit button
    Then navigate to home page

    Examples: 
      | username | password |
      | shehzad  |   123456 |

  @Sanity @Regression
  Scenario Outline: Test login with valid cred.
    Given enter the URl
    And login with valid <username> and <password>
    When click on submit button
    Then navigate to home page

    Examples: 
      | username | password |
      | sonali   |    12345 |

  Scenario Outline: Test login with valid cred.
    Given enter the URl
    And login with valid <username> and <password>
    When click on submit button
    Then navigate to home page

    Examples: 
      | username | password |
      | pihu     |    12345 |
