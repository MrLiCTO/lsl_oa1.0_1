package com.shilong.oa.view.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.shilong.oa.domain.User;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
//		System.out.println("------------------------------->之前");
//		String result=arg0.invoke();
//		System.out.println("------------------------------->之后");
//		return result;
		User user=(User) ActionContext.getContext().getSession().get("user");
		String privUrl=arg0.getProxy().getNamespace()+arg0.getProxy().getActionName();
		
		if(user==null){
			if(privUrl.startsWith("/user_login")){
				return arg0.invoke();
			}else{
				return "loginUI";
			}
		}else{
			if(user.hasPrivilegeByUrl(privUrl)){
				return arg0.invoke();
			}else{
				return "noPrivilegeError";
			}
		}
		
	}

}
