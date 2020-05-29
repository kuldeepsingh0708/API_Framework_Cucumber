package Resources;

public enum API_Resources 

{
	
	login("/api/v1/auth/users/login"),
	logout("/api/v1/auth/users/logout"),
	users("/api/v1/common/users"),
	country_List("/api/v1/common/countries?is_top=true");
	
	private String resource;

	API_Resources(String resource) 
	{
		
		this.resource=resource;
		
	}
	
	public String getResource()
	{
		
		return resource;
		
	}
	
}
