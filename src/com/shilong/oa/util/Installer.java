package com.shilong.oa.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shilong.oa.domain.Privilege;
import com.shilong.oa.domain.User;

@Component
public class Installer {
	
		@Resource
		SessionFactory sessionFactory;
		@Transactional
		public void install(){
			Session session=sessionFactory.getCurrentSession();
//			保存超级管理员用户
					User user =new User();
					user.setName("超级管理员");
					user.setLoginName("admin");
					user.setPassword(DigestUtils.md5Hex("xin123456"));
					session.save(user);
//			保存权限数据
					Privilege menu,menu1,menu2,menu3,menu4,menu5;
					Privilege menu1_1,menu1_2,menu1_3,menu1_4,menu1_5;
					Privilege menu2_1,menu2_2,menu2_3,menu2_4;
					Privilege menu3_1,menu3_2,menu3_3,menu3_4,menu3_5;
					
					menu=new Privilege("系统管理",null,null);
					menu1=new Privilege("岗位管理","/role_list",menu);
					menu2=new Privilege("部门管理","/department_list",menu);
					menu3=new Privilege("用户管理","/user_list",menu);
					
					
					session.save(menu);
					session.save(menu1);
					session.save(menu2);
					session.save(menu3);
					
					
					menu1_1=new Privilege("岗位列表","/role_list",menu1);
					menu1_2=new Privilege("岗位删除","/role_delete",menu1);
					menu1_3=new Privilege("岗位添加","/role_add",menu1);
					menu1_4=new Privilege("岗位修改","/role_edit",menu1);
					menu1_5=new Privilege("设置权限","/role_setPrivilege",menu1);
					
					session.save(menu1_1);
					session.save(menu1_2);
					session.save(menu1_3);
					session.save(menu1_4);
					session.save(menu1_5);
					
					menu2_1=new Privilege("部门列表","/department_list",menu2);
					menu2_2=new Privilege("部门删除","/department_delete",menu2);
					menu2_3=new Privilege("部门添加","/department_add",menu2);
					menu2_4=new Privilege("部门修改","/department_edit",menu2);
					
					
					session.save(menu2_1);
					session.save(menu2_2);
					session.save(menu2_3);
					session.save(menu2_4);
					
					
					menu3_1 = new Privilege("用户列表", "/user_list", menu3);
					menu3_2 = new Privilege("用户删除", "/user_delete", menu3);
					menu3_3 = new Privilege("用户添加", "/user_add", menu3);
					menu3_4 = new Privilege("用户修改", "/user_edit", menu3);
					menu3_5 = new Privilege("初始化密码", "/user_initPassword", menu3);
					
					session.save(menu3_1);
					session.save(menu3_2);
					session.save(menu3_3);
					session.save(menu3_4);
					session.save(menu3_5);
					//---------------------------------------------------------
					//网上交流
					menu=new Privilege("网上交流",null,null);
					menu1=new Privilege("论坛管理","/forumManage_list",menu);
					menu2=new Privilege("论坛","/forum_list",menu);
					session.save(menu);
					session.save(menu1);
					session.save(menu2);
					//---------------------------------------------------------
					//审批流转
					
					menu=new Privilege("审批流转",null,null);
					menu1=new Privilege("审批流程管理","/processDefinition_list",menu);
					menu2=new Privilege("申请模板管理","/template_list",menu);
					menu3=new Privilege("起草申请","/flow_templateList",menu);
					menu4=new Privilege("待我审批","/flow_MyTaskList",menu);
					menu5=new Privilege("我的申请查询","/flow_myApplicatiopnList",menu);
					
					session.save(menu);
					session.save(menu1);
					session.save(menu2);
					session.save(menu3);
					session.save(menu4);
					session.save(menu5);
					
		}
		
		public static void main(String[] args) {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			Installer install=(Installer) ctx.getBean("installer");
			install.install();
		}
}
