package Resources;

import POJO.*;

public class Test_Data 

{

	public UserLogin UserValidationPayLoad(String Email, String Password) 
	
	{
		
		UserLogin ul = new UserLogin();
		ul.setEmail(Email);
		ul.setPassword(Password);
		
		return ul;
		
	}
	
	

}
