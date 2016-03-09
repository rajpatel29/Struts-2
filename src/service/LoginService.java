package service;

import model.User;

public class LoginService 
{
	public boolean verify(User user)
	{
		if(user.getUserId().equals("rutvik") && user.getPassword().equals("123"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
