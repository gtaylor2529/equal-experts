Feature: Create Booking

  Scenario: Create a valid booking
    When I enter valid booking details
    Then the booking is created successfully