package com.shilong.oa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable{
		private Long id;
		private String name;
		private String description;
		private Set<User> users=new HashSet<User>();
		private Set<Department>  children =new HashSet<Department>();
		private   Department parent;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Set<User> getUsers() {
			return users;
		}
		public void setUsers(Set<User> users) {
			this.users = users;
		}
		public Set<Department> getChildren() {
			return children;
		}
		public void setChildren(Set<Department> children) {
			this.children = children;
		}
		public Department getParent() {
			return parent;
		}
		public void setParent(Department parent) {
			this.parent = parent;
		}
	
}
