package action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import model.User;
import service.LoginService;

public class LoginAction extends ActionSupport implements ModelDriven<User>
{
	private User user = new User();

	  public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void validate() 
	  {
		  //Question is how will we return string from this method because return type is String
		  //It will automatically redirect to default page
		  //see login.xml page check result tag which has "input" name that is default page
		  
		System.out.println("validate " + user.getUserId() + "  ==  " + user.getPassword() );
		  if(StringUtils.isEmpty(user.getUserId()))
		  {
			  //User Id is blank
			  System.out.println("Blank");
			  addFieldError("user.userId", "User Id can not be blanck");
		  }
		  if(StringUtils.isEmpty(user.getPassword()))
		  {
			  //Passsword is blank
			  addFieldError("user.password", "Password can not be blanck");
		  }
	  }
	
	public String execute()
	{
		LoginService loginService = new LoginService();
		
		if(loginService.verify(user))
		{
			//Best Practice 1
			return SUCCESS;
		}
		else
		{
			//Best Practice 1
			return LOGIN;
		}
	}

	@Override
	public User getModel() 
	{
		return user;
	}
	
	
}
