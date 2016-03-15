package com.shilong.oa.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User  implements Serializable{
		private  Long id;
		private String name;
		private String gender;
		private Department department;
		private Set<Role> roles=new HashSet<Role>();
		private String loginName;
		private String password;
		private String phoneNumber;
		private String email;
		private String description;
		
		public boolean hasPrivilegeByName(String name1){
		//System.out.print("+++++++++++++"+roles.toString()+"1==================");

			if(isAdmin()){
			
				return true;
			}
				Iterator<Role> it=roles.iterator();
			while(it.hasNext()){
		
				for(Privilege p:it.next().getPrivileges()){
			
					if(name1.equals(p.getName())){
						return true;
					}	
				}
			}
			return false;
		}
		public boolean hasPrivilegeByUrl(String privUrl){
			
				if(isAdmin()){
				
					return true;
				}
				int pos=privUrl.indexOf("?");
				if(pos>-1){
					privUrl=privUrl.substring(0, pos);
				}
				if(privUrl.endsWith("UI")){
					privUrl=privUrl.substring(0, privUrl.length()-2);
				}
				
				Collection<String> allPrivUrl=(Collection<String>) ActionContext.getContext().getApplication().get("allPrivUrls");
				if(!allPrivUrl.contains(privUrl)){
					return true;
				}else{
					Iterator<Role> it=roles.iterator();
					while(it.hasNext()){
						
						for(Privilege p:it.next().getPrivileges()){
					
							if(privUrl.equals(p.getUrl())){
						
								return true;
							}	
						}
					}
					return false;
				}
			}

		public boolean isAdmin(){
			return "admin".equals(loginName);
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Department getDepartment() {
			return department;
		}
		public void setDepartment(Department department) {
			this.department = department;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
}
