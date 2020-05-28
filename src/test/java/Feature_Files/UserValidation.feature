Feature: Validation Feature

@Login @Sanity @Regression
Scenario Outline: Verify if Login is being sucessfull by email and password using login API

Given 	user login payload with "<Email>" and "<Password>"
When 	user call "login" API with "POST" http request
Then 	API call got sucess with Status 200
And 	"status" in response body is "success"
And 	"message" in response body is "User logged in successfully"


Examples:

	|Email						| Password |
	|amchimumbai@erostest.com	| password |
	|kuldeepsingh0708@gmail.com	| password |
	

@UserDetails @Sanity @Regression
Scenario: Verify User Details by using users API

Given users payload
When  user call "users" API with "GET" http request
Then  API call got sucess with Status 200
And   "status" in response "success"	

	
@Logout	@Sanity @Regression
Scenario: Verify if Logout is sucessfull by using logout API

Given logout payload
When  user call "logout" API with "POST" http request
Then  API call got sucess with Status 200
And   "status" in response "success"

