Feature: Delete Booking

  Scenario: Delete an existing booking
    Given a booking exists
    When I delete the existing booking
    Then the booking is deleted successfully