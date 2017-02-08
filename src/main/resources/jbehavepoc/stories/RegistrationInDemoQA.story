Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Register an user
Given I open http://demoqa.com/registration/
When I fill the registration form
And I submit the registration form
Then Thank you for your registration message is displayed

Scenario: Try to submit a registration with and empty form
Given I open http://demoqa.com/registration/
When I submit the registration form
Then * This field is required Error messages are displayed
