package Interceptor_Pkg;

import java.util.Map;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;



public class AuthInterceptor implements Interceptor  {


	
	
	@Override
	public void destroy() {
	
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> sessionAttribute =invocation.getInvocationContext().getSession();
		if(sessionAttribute == null && sessionAttribute.get("authorized")==null)
		{
			return "failure";
		}
		
		if(sessionAttribute.get("authorized")=="yes")
		{
			
			return invocation.invoke();
		}
		else
		{
			return "failure";
		}
	}

	
}
