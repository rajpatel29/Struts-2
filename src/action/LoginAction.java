package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import model.User;
import service.LoginService;

public class LoginAction  extends ActionSupport implements ModelDriven<User> , ServletRequestAware
{
	private User user = new User();
	HttpServletRequest request;

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;		
	}
	
	 public HttpSession getSession(){
	        return request.getSession();
	  }

	 
	 
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
		  
		  if(StringUtils.isEmpty(user.getUserId()))
		  {
			  //User Id is blank
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
			HttpSession session = request.getSession();
			session.setAttribute("authorized", "yes");
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
