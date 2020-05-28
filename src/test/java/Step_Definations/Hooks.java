package Step_Definations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@Logout")

	public void LoginRequired() throws IOException

	{
		UserValidation_StepDefination UserStepDef = new UserValidation_StepDefination();

		if (UserValidation_StepDefination.Token == null || UserValidation_StepDefination.Token.length() == 0)

		{
			UserStepDef.user_login_payload_with_and("kuldeepsingh0708@gmail.com", "password");
			UserStepDef.user_call_API_with_http_request("login", "POST");
			UserStepDef.in_response_body_is("status", "success");
			System.out.println(UserValidation_StepDefination.Token);

		}

	}

}
