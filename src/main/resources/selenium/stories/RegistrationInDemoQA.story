Meta:

As a user
I want to fill the registration form
So that I can submit the form

Scenario: Register an user
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I mark my [hobbies]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter confirmation [con_password]
And I enter a bio
And I submit the registration form
Then A [message] is displayed

Examples:
|firstname|lastname|maritalStatus|hobbies|country|dd|mm|aaaa|username|email|phoneNumber|password|con_password|message|
|Albert|Einstein|single|dancing|Germany|14|3|1950|||0492515300519|6;78Z9cW|6;78Z9cW|Thank you for your registration|
|Muscowequan|Hokolesqua|married|reading|Antigua and Barbuda|31|12|1960|||0492515300519|6;78Z9cW|6;78Z9cW|Thank you for your registration|
|Magnus|Atherton|divorced|cricket|Bosnia and Herzegovina|29|2|1972|||0492515300519|6;78Z9cW|6;78Z9cW|Thank you for your registration|
|Katniss|Everdeen||cricket|United States|30|11|1980|||0492515300519|6;78Z9cW|6;78Z9cW|Thank you for your registration|
|фанасий|фотобанк|divorced|reading,dancing|Chile|1|1|1999|||0492515300519|6;78Z9cW|6;78Z9cW|Thank you for your registration|
|Ernest|Laurence|single|cricket,dancing,reading|Canada|9|8|1982|||0492515300519|6;78Z9cW|6;78Z9cW|Thank you for your registration|
|Ernest|Laurence|single|cricket,dancing,reading|Canada|9|8|1982|||0492515300519|6;78Z9cW|6;78Z9cW|Thank you for your registration|
|-- MARITALSTATUS=single, married, divorced, Empty
|-- HOBBIES=1, 2, 3
|-- NOTES: username and email will be randomly generated if you left these fields empty

Scenario: Try to register an user with invalid phone number data
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I mark my [hobbies]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter confirmation [con_password]
And I enter a bio
And I submit the registration form
Then A [phoneNumberError] is displayed

Examples:
|firstname|lastname|maritalStatus|hobbies|country|dd|mm|aaaa|username|email|phoneNumber|password|con_password|phoneNumberError|
|Colin|Hebert|single|cricket|Mexico|18|4|1965|||NUMBER|6;78Z9cW|6;78Z9cW|* Minimum 10 Digits starting with Country Code|
|Ricardo|Gomez|single|cricket|Mexico|18|4|1965|||123456789|6;78Z9cW|6;78Z9cW|* Minimum 10 Digits starting with Country Code|

Scenario: Try to register an user that already exist
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I mark my [hobbies]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter confirmation [con_password]
And I enter a bio
And I submit the registration form
Then A [usernameError] is displayed

Examples:
|firstname|lastname|maritalStatus|hobbies|country|dd|mm|aaaa|username|email|phoneNumber|password|con_password|usernameError|
|Colin|Hebert|single|cricket|Mexico|18|4|1965|liroingo||3156137930|6;78Z9cW|6;78Z9cW|Error: Username already exists|


Scenario: Try to register an user with an email already exist
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I mark my [hobbies]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter confirmation [con_password]
And I enter a bio
And I submit the registration form
Then A [emailError] is displayed

Examples:
|firstname|lastname|maritalStatus|hobbies|country|dd|mm|aaaa|username|email|phoneNumber|password|con_password|emailError|
|Ernest|Laurence|single|cricket,dancing,reading|Canada|9|8|1982||liroingo@gmail.com|0492515300519|6;78Z9cW|6;78Z9cW|Error: E-mail address already exists|


Scenario: Try to register an user with invalid email data
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I mark my [hobbies]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter confirmation [con_password]
And I enter a bio
And I submit the registration form
Then An [invalidEmailError] is displayed

Examples:
|firstname|lastname|maritalStatus|hobbies|country|dd|mm|aaaa|username|email|phoneNumber|password|con_password|invalidEmailError|
|Ernest|Laurence|single|cricket,dancing,reading|Canada|9|8|1982||email|0492515300519|6;78Z9cW|6;78Z9cW|* Invalid email address|
|Ernest|Laurence|single|cricket,dancing,reading|Canada|9|8|1982||@example.com|0492515300519|6;78Z9cW|6;78Z9cW|* Invalid email address|


Scenario: Try to register an user with invalid password
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I mark my [hobbies]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter confirmation [con_password]
And I enter a bio
And I submit the registration form
Then A [passwordError] is displayed

Examples:
|firstname|lastname|maritalStatus|hobbies|country|dd|mm|aaaa|username|email|phoneNumber|password|con_password|passwordError|
|Ernest|Laurence|single|cricket,dancing,reading|Canada|9|8|1982|||0492515300519|6;78|6;78|* Minimum 8 characters required|


Scenario: Try to register an user with a mismatch password
Given I open http://demoqa.com/registration/
When I enter [firstname] and [lastname]
And I choose [maritalStatus]
And I mark my [hobbies]
And I select [country]
And I select Date of Birth [dd] [mm] [aaaa]
And I enter [username]
And I enter [email]
And I enter this [phoneNumber]
And I enter this [password]
And I enter confirmation [con_password]
And I enter a bio
And I submit the registration form
Then A [mismatchError] is displayed

Examples:
|firstname|lastname|maritalStatus|hobbies|country|dd|mm|aaaa|username|email|phoneNumber|password|con_password|mismatchError|
|Ernest|Laurence|single|cricket,dancing,reading|Canada|9|8|1982|||0492515300519|6;78Z9cW|6;78Z9cM|* Fields do not match|

Scenario: Try to submit a registration with and empty form
Given I open http://demoqa.com/registration/
When I submit the registration form
Then * This field is required Error messages are displayed






