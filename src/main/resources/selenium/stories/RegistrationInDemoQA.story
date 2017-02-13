Meta:

As a user
I want to fill the registration form
So that I can submit the form

Scenario: Register an user
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I like to [dance], [reading] and [cricket]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter a bio
And I submit the registration form
Then A [message] is displayed

Examples:
|firstname|lastname|maritalStatus|dance|reading|cricket|country|dd|mm|aaaa|username|email|phoneNumber|password|message|
|Albert|Einstein|single|true|true|true|Germany|14|3|1950|||0492515300519|6;78Z9cW|Thank you for your registration|