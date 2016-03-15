package com.shilong.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {
	private static final long serialVersionUID = 2217762666759103065L;
			public String index(){
				return "index";
				
			}
			
			
			public String top(){
				return "top";
				
			}
			
			
			
			public String bottom(){
				return "bottom";
				
			}
			
			
			public String left(){
				return "left";
				
			}
			
			
			
			public String right(){
				return "right";
				
			}
}
