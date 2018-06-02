Feature: Refund faulty items

  Broken items should be refunded if you have receipt

  Scenario: Testing a simple spring and cucumber data sharing
    Given that Deepak bought a faulty laptop for $500
    When he return the kettle to the store
    Then he will get $500 refunded